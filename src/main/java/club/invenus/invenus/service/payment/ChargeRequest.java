package club.invenus.invenus.service.payment;

import lombok.Data;

@Data
public class ChargeRequest {

    public enum Currency {
        EUR,
        USD
    }

    private final String description;
    private final int amount;
    private final Currency currency;
    private final String stripeEmail;
    private final String stripeToken;

}
