package club.invenus.invenus.service.payment;

import club.invenus.invenus.exception.ProductNotFoundException;
import club.invenus.invenus.repository.AvailableTicketRepository;
import club.invenus.invenus.service.dto.CartDTO;
import club.invenus.invenus.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Service
public class CheckoutService {

    private final AvailableTicketRepository availableTicketRepository;

    @Autowired
    public CheckoutService(AvailableTicketRepository availableTicketRepository) {
        this.availableTicketRepository = availableTicketRepository;
    }

    public BigDecimal calculatePrice(@NotNull CartDTO cart) {
        return cart.getProducts().stream()
                .map(this::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transactional
    public BigDecimal calculatePrice(@NotNull ProductDTO product) {
        return availableTicketRepository.findById(product.getTicketId())
                .orElseThrow(() -> new ProductNotFoundException(product.getTicketId()))
                .getPrice();
    }

}
