package club.invenus.invenus.service.payment;


import club.invenus.invenus.domain.payment.Charge;
import club.invenus.invenus.exception.BadRequestException;
import club.invenus.invenus.exception.UnauthorizedException;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.LineItem;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class PaymentService {

    @Value("${invenus.web-url}")
    private String webUrl;

    @Value("${stripe.secret-key}")
    private String secretKey;

    @Autowired
    public PaymentService() {
    }

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Session createCheckoutSession(@NotNull List<SessionCreateParams.LineItem> items) throws StripeException {
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(webUrl + "/webhook/stripe/success")
                        .setCancelUrl(webUrl + "/webhook/stripe/cancel")
                        .setAllowPromotionCodes(false)
                        .addAllLineItem(items)
                        .setAutomaticTax(
                                SessionCreateParams.AutomaticTax.builder()
                                        .setEnabled(true)
                                        .build())
                        .build();
        return Session.create(params);
    }

    public SessionCreateParams.LineItem createLineItem(UUID productId, String item, int quantity, String description, BigDecimal price) {
        return SessionCreateParams.LineItem.builder()
                .setQuantity((long) quantity)
                .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("eur")
                                .setUnitAmountDecimal(price.multiply(BigDecimal.valueOf(100)))
                                .setTaxBehavior(SessionCreateParams.LineItem.PriceData.TaxBehavior.INCLUSIVE)
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName(item)
                                        .putMetadata("product_id", productId.toString())
                                        .setDescription(description)
                                        .build())
                                .build())
                .setAdjustableQuantity(SessionCreateParams.LineItem.AdjustableQuantity.builder().setEnabled(false).build())
                .build();
    }

}
