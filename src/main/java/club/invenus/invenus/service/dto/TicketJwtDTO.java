package club.invenus.invenus.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
public class TicketJwtDTO {

    private final String title;
    private final String club;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDateTime from;
    private final String address;
    private final int postCode;
    private final String city;

}
