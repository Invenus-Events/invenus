package club.invenus.invenus.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class ConfirmationEmailDTO {

    private final String name;
    private final String orderNumber;
    private final String subject;
    private final String date;
    private final double subTotal;
    private final double vat;
    private final double total;
    private final List<TicketDTO> orders;

    @AllArgsConstructor
    @Builder
    public static class TicketDTO {
        private final String title;
        private final String organizer;
        private final String url;
        private double price;
    }

}
