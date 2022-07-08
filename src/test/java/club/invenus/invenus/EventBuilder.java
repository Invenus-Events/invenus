package club.invenus.invenus;

import club.invenus.invenus.domain.TimeFrame;
import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.event.EventInstance;
import club.invenus.invenus.domain.media.Media;
import club.invenus.invenus.domain.rating.RatingCollection;
import club.invenus.invenus.domain.ticket.AvailableEventTicket;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
class EventBuilder {

    @Builder.Default
    private int year = 2022;
    private int month;
    private int dayStart;
    private int dayEnd;
    private int hourStart;
    private int hourEnd;
    private double price;
    private String media;

    private String organizer;
    private String title;
    private String description;

    public Event toEvent() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(year, month, dayStart, hourStart, 0, 0),
                        LocalDateTime.of(year, month, dayEnd, hourEnd, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(price));

        Media media = new Media();
        media.setOverwrite(this.media);

        Event event = Event.builder()
                .organizer(organizer)
                .title(title)
                .description(description)
                .capacity(100)
                .sold(0)
                .price(BigDecimal.valueOf(price))
                .ratingCollection(new RatingCollection())
                .media(media)
                .eventInstances(List.of(eventInstance))
                .build();
        eventInstance.setEvent(event);

        return event;
    }
}
