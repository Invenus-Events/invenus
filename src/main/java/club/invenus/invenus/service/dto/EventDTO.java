package club.invenus.invenus.service.dto;

import club.invenus.invenus.domain.Location;
import club.invenus.invenus.domain.TimeFrame;
import club.invenus.invenus.domain.event.EventInstance;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@RequiredArgsConstructor
@ToString
@Getter
public class EventDTO {

    private final UUID id;

    private final UUID ticketId;

    @Size(min = 1, max = 30)
    private final String title;

    private final TimeFrame timeFrame;

    @Positive
    private final BigDecimal price;

    private final ClubDTO club;

    @Size(min = 1, max = 30)
    private final String organizer;

    @Size(min = 1, max = 150)
    private final String imageUrl;

    @Size(min = 1)
    private final String description;

    private final Location location;

    public EventDTO(@NotNull EventInstance eventInstance) {
        var event = eventInstance.getEvent();

        this.id = eventInstance.getEventInstanceID();
        this.ticketId = eventInstance.getTicket().getAvailableTicketId();
        this.title = event.getTitle();
        this.timeFrame = eventInstance.getTimeFrame();
        this.price = event.getPrice();
        this.club = new ClubDTO(event.getClub());
        this.organizer = event.getOrganizer();
        this.imageUrl = event.getMedia().getURL();
        this.description = event.getDescription();
        this.location = event.getClub().getLocation();
    }

}
