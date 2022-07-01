package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.payment.Charge;
import club.invenus.invenus.domain.profile.User;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Inheritance(strategy = InheritanceType.JOINED)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id", nullable = false)
    private UUID ticketId;

    @OneToOne
    @JoinColumn(name = "available_ticket_id")
    private AvailableTicket availableTicket;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "charge_id", nullable = false)
    private Charge charge;

}
