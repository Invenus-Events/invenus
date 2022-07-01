package club.invenus.invenus.web;

import club.invenus.invenus.service.payment.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeWebhookResource {

    private final CheckoutService checkoutService;

    @Autowired
    public StripeWebhookResource(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/webhook/stripe")
    public void stripeWebhook(@RequestBody String payload, @RequestHeader(name = "STRIPE_SIGNATURE") String sigHeader) {
        checkoutService.handleWebhook(payload, sigHeader);
    }

}
