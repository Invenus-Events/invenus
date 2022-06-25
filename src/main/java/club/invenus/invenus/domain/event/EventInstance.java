package club.invenus.invenus.domain.event;

import club.invenus.invenus.domain.TimeFrame;
import club.invenus.invenus.domain.profile.DJ;
import club.invenus.invenus.domain.ticket.AvailableClubTicket;
import club.invenus.invenus.domain.ticket.AvailableEventTicket;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "event_instance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventInstance {

    @Id
    @Column(name = "event_instance_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventInstanceID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", updatable = false)
    private Event event;

    @Embedded
    private TimeFrame timeFrame;

    @ManyToOne
    @JoinColumn(name = "dj_id")
    private DJ dj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "available_ticket_id")
    private AvailableEventTicket ticket;
}
