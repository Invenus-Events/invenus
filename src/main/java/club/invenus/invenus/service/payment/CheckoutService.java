package club.invenus.invenus.service.payment;

import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.ticket.AvailableClubTicket;
import club.invenus.invenus.domain.ticket.AvailableEventTicket;
import club.invenus.invenus.domain.ticket.AvailableTicket;
import club.invenus.invenus.exception.InternalServerException;
import club.invenus.invenus.exception.ProductNotFoundException;
import club.invenus.invenus.repository.AvailableTicketRepository;
import club.invenus.invenus.service.dto.CartDTO;
import club.invenus.invenus.service.dto.CheckoutDTO;
import club.invenus.invenus.service.dto.ProductDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CheckoutService {

    private final PaymentService paymentService;
    private final AvailableTicketRepository availableTicketRepository;

    @Autowired
    public CheckoutService(PaymentService paymentService, AvailableTicketRepository availableTicketRepository) {
        this.paymentService = paymentService;
        this.availableTicketRepository = availableTicketRepository;
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
    public BigDecimal calculatePrice(@NotNull ProductDTO product) {
        return availableTicketRepository.findById(product.getTicketId())
                .orElseThrow(() -> new ProductNotFoundException(product.getTicketId()))
                .getPrice();
    }

}
