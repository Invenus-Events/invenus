package club.invenus.invenus.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutResource {

    @PostMapping("/checkout")
    public String checkout() {
        return "Checkout";
    }


}
