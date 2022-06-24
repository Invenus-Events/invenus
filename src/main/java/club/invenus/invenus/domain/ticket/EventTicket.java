package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.event.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "event_ticket")
@Getter
@Setter
public class EventTicket extends BaseTicket {

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;



}
