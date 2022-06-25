package club.invenus.invenus.web;

import club.invenus.invenus.service.dto.CartDTO;
import club.invenus.invenus.service.dto.CheckoutDTO;
import club.invenus.invenus.service.payment.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class CheckoutResource {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutResource(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/checkout")
    public CheckoutDTO checkout(@RequestBody @NotNull CartDTO cart) {
        return checkoutService.createCheckout(cart);
    }


}
