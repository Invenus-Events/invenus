package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.event.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "available_event_ticket")
@Getter
@Setter
public class AvailableEventTicket extends AvailableTicket {

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


}
