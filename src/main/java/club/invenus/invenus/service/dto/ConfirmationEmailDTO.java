package club.invenus.invenus.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConfirmationEmailDTO {

    private final String name;
    private final String orderNumber;
    private final String subject;
    private final String paymentMethod;
    private final String date;
    private final double subTotal;
    private final double vat;
    private final double total;
    private final List<TicketDTO> orders;

    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class TicketDTO {
        private final String title;
        private final String organizer;
        private final String url;
        private double price;
    }

}
