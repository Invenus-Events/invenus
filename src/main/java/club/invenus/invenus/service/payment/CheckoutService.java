package club.invenus.invenus.service.payment;

import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.payment.Charge;
import club.invenus.invenus.domain.ticket.AvailableClubTicket;
import club.invenus.invenus.domain.ticket.AvailableEventTicket;
import club.invenus.invenus.domain.ticket.AvailableTicket;
import club.invenus.invenus.domain.ticket.Ticket;
import club.invenus.invenus.exception.BadRequestException;
import club.invenus.invenus.exception.InternalServerException;
import club.invenus.invenus.exception.ProductNotFoundException;
import club.invenus.invenus.exception.UnauthorizedException;
import club.invenus.invenus.repository.AvailableTicketRepository;
import club.invenus.invenus.repository.ChargeRepository;
import club.invenus.invenus.service.EmailService;
import club.invenus.invenus.service.TicketService;
import club.invenus.invenus.service.dto.CartDTO;
import club.invenus.invenus.service.dto.CheckoutDTO;
import club.invenus.invenus.service.dto.ConfirmationEmailDTO;
import club.invenus.invenus.service.dto.ProductDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.LineItem;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CheckoutService {

    private final EmailService emailService;
    private final PaymentService paymentService;
    private final TicketService ticketService;
    private final AvailableTicketRepository availableTicketRepository;
    private final ChargeRepository chargeRepository;

    @Value("${stripe.webhook-secret}")
    private String webhookSecret;
    @Value("${email.template.confirmation}")
    private String confirmationEmailTemplate;

    @Autowired
    public CheckoutService(EmailService emailService, PaymentService paymentService, TicketService ticketService, AvailableTicketRepository availableTicketRepository, ChargeRepository chargeRepository) {
        this.emailService = emailService;
        this.paymentService = paymentService;
        this.ticketService = ticketService;
        this.availableTicketRepository = availableTicketRepository;
        this.chargeRepository = chargeRepository;
    }

    public void handleWebhook(@NotNull String payload, @NotNull String sigHeader) {
        com.stripe.model.Event event;
        try {
            event = Webhook.constructEvent(payload, sigHeader, webhookSecret);
        } catch (SignatureVerificationException e) {
            throw new UnauthorizedException("Invalid signature", e);
        }

        StripeObject stripeObject = event.getDataObjectDeserializer().getObject().orElseThrow(() -> new BadRequestException("Invalid event"));

        switch (event.getType()) {
            case "checkout.session.completed" -> handleCheckoutSessionCompleted((Session) stripeObject);
            case "checkout.session.canceled" -> handleCheckoutSessionCanceled((Session) stripeObject);
            default -> throw new BadRequestException("Unknown event type: " + event.getType());
        }
    }

    @Transactional
    void handleCheckoutSessionCompleted(@NotNull Session session) {
        log.info("Checkout session completed: " + session.getId());

        List<AvailableTicket> cart = Arrays.stream(session.getMetadata().get("product_ids").split(","))
                .map(UUID::fromString)
                .map(this::getTicket)
                .toList();

        Charge charge = Charge.builder()
                .stripeId(session.getId())
                .amountSubtotal(new BigDecimal(session.getAmountSubtotal()).divide(BigDecimal.valueOf(100), RoundingMode.FLOOR))
                .amountTotal(new BigDecimal(session.getAmountTotal()).divide(BigDecimal.valueOf(100), RoundingMode.FLOOR))
                .cart(cart)
                .build();

        chargeRepository.save(charge);

        List<Ticket> tickets = ticketService.createTickets(cart, charge);
        Map<String, Object> ticketData = createConfirmationEmailData(session, tickets);
        emailService.sendEmail(session.getCustomerDetails().getName(), session.getCustomerDetails().getEmail(), confirmationEmailTemplate, ticketData);
    }

    private Map<String, Object> createConfirmationEmailData(Session session, List<Ticket> tickets) {
        List<ConfirmationEmailDTO.TicketDTO> orders = tickets.stream()
                .map(ticket -> ConfirmationEmailDTO.TicketDTO.builder()
                        .title(getName(ticket.getAvailableTicket()))
                        .organizer(getDescription(ticket.getAvailableTicket()))
                        .url(ticketService.getTicketUrl(ticket))
                        .price(ticket.getAvailableTicket().getPrice().doubleValue())
                        .build())
                .toList();

        ConfirmationEmailDTO confirmationEmailData = ConfirmationEmailDTO.builder()
                .name(session.getCustomerDetails().getName())
                .orderNumber(session.getId())
                .subject("INVENUS.CLUB - TICKETS")
                .paymentMethod("Stripe")
                .date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")))
                .subTotal(session.getAmountSubtotal() / 100.0)
                .vat((session.getAmountTotal() - session.getAmountSubtotal()) / 100.0)
                .total(session.getAmountTotal() / 100.0)
                .orders(orders)
                .build();

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {
        };
        return mapper.convertValue(confirmationEmailData, typeRef);
    }

    void handleCheckoutSessionCanceled(@NotNull Session session) {
        log.info("Checkout session canceled: " + session.getId());
    }

    public CheckoutDTO createCheckout(@NotNull CartDTO cart) {
        String url = createCheckoutSession(cart).getUrl();
        return new CheckoutDTO(url);
    }

    @Transactional
    public Session createCheckoutSession(@NotNull CartDTO cart) {
        List<SessionCreateParams.LineItem> items = cart.getProducts().stream()
                .map(this::createLineItem)
                .toList();
        String products = cart.getProducts().stream()
                .map(ProductDTO::getTicketId)
                .map(UUID::toString)
                .collect(Collectors.joining(","));
        Map<String, String> metadata = new HashMap<>();
        metadata.put("product_ids", products);
        try {
            return paymentService.createCheckoutSession(metadata, items);
        } catch (StripeException e) {
            throw new InternalServerException("Failed to create checkout session", e);
        }
    }

    @Transactional
    public SessionCreateParams.LineItem createLineItem(@NotNull ProductDTO product) {
        AvailableTicket availableTicket = availableTicketRepository.findById(product.getTicketId())
                .orElseThrow(() -> new ProductNotFoundException(product.getTicketId()));
        String name = getName(availableTicket);
        String description = getDescription(availableTicket);

        return paymentService.createLineItem(name, product.getAmount(), description, availableTicket.getPrice());
    }

    private String getName(@NotNull AvailableTicket ticket) {
        if (ticket instanceof AvailableEventTicket t) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            Event event = t.getEventInstance().getEvent();
            LocalDateTime time = t.getEventInstance().getTimeFrame().getFrom();

            return event.getTitle() + " @ " + time.format(formatter);
        } else if (ticket instanceof AvailableClubTicket t) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            return t.getClub().getName() + " @ " + formatter.format(t.getDate());
        } else {
            throw new IllegalArgumentException("Unknown ticket type");
        }
    }

    private String getDescription(@NotNull AvailableTicket ticket) {
        if (ticket instanceof AvailableEventTicket t) {
            return "Event Ticket";
        } else if (ticket instanceof AvailableClubTicket t) {
            return "Club Ticket";
        } else {
            throw new IllegalArgumentException("Unknown ticket type");
        }
    }

    @Transactional
    public AvailableTicket getTicket(@NotNull UUID productId) {
        return availableTicketRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }

}
