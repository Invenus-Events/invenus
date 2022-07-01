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
import club.invenus.invenus.service.TicketService;
import club.invenus.invenus.service.dto.CartDTO;
import club.invenus.invenus.service.dto.CheckoutDTO;
import club.invenus.invenus.service.dto.ProductDTO;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.LineItem;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
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
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CheckoutService {

    private final PaymentService paymentService;
    private final TicketService ticketService;
    private final AvailableTicketRepository availableTicketRepository;
    private final ChargeRepository chargeRepository;

    @Value("${stripe.secret-key}")
    private String secretKey;

    @Autowired
    public CheckoutService(PaymentService paymentService, TicketService ticketService, AvailableTicketRepository availableTicketRepository, ChargeRepository chargeRepository) {
        this.paymentService = paymentService;
        this.ticketService = ticketService;
        this.availableTicketRepository = availableTicketRepository;
        this.chargeRepository = chargeRepository;
    }

    public void handleWebhook(@NotNull String payload, @NotNull String sigHeader) {
        com.stripe.model.Event event;
        try {
            event = Webhook.constructEvent(payload, sigHeader, secretKey);
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

        List<AvailableTicket> cart = StreamSupport.stream(session.getLineItems().autoPagingIterable().spliterator(), false)
                .map(LineItem::getPrice)
                .map(price -> price.getMetadata().get("product_id"))
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
        // todo: send email to user with receipt
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
        try {
            return paymentService.createCheckoutSession(items);
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

        return paymentService.createLineItem(availableTicket.getAvailableTicketId(), name, product.getAmount(), description, availableTicket.getPrice());
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
