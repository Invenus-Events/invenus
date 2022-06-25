package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.event.EventInstance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "available_event_ticket")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AvailableEventTicket extends AvailableTicket {

    @OneToOne(mappedBy = "ticket")
    @JoinColumn(name = "event_instance_id")
    private EventInstance eventInstance;

}
