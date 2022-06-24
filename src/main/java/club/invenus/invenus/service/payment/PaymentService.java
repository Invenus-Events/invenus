package club.invenus.invenus.service.payment;


import club.invenus.invenus.service.dto.CartDTO;
import com.stripe.Stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.checkout.Session;
import com.stripe.param.InvoiceItemCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${invenus.base-url}")
    private String baseUrl;

    @Value("${stripe.secret-key}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Session createCheckoutSession(@NotNull List<SessionCreateParams.LineItem> items) throws StripeException {
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(baseUrl + "/webhook/stripe/success")
                        .setCancelUrl(baseUrl + "/webhook/stripe/cancel")
                        .setAllowPromotionCodes(false)
                        .addAllLineItem(items)
                        .setAutomaticTax(
                                SessionCreateParams.AutomaticTax.builder()
                                        .setEnabled(true)
                                        .build())
                        .build();
        return Session.create(params);
    }

    public SessionCreateParams.LineItem createLineItem(String item, int quantity, String description, BigDecimal price) {
        return SessionCreateParams.LineItem.builder()
                .setQuantity((long) quantity)
                .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("eur")
                                .setProduct(item)
                                .setUnitAmountDecimal(price)
                                .setTaxBehavior(SessionCreateParams.LineItem.PriceData.TaxBehavior.INCLUSIVE)
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setDescription(description)
                                        .build())
                                .build())
                .setAdjustableQuantity(SessionCreateParams.LineItem.AdjustableQuantity.builder().setEnabled(false).build())
                .build();
    }

    public Charge charge(ChargeRequest chargeRequest) throws AuthenticationException, StripeException {
        Map<String, Object> chargeParams = new HashMap<>();

        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());

        return Charge.create(chargeParams);

    }

}
