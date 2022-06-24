package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.payment.Charge;
import club.invenus.invenus.domain.profile.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Ticket {

    @Id
    @Column(name = "ticket_id", nullable = false)
    private UUID ticketId;

    @OneToOne
    @JoinColumn(name = "available_ticket_id", nullable = false)
    private AvailableTicket availableTicket;

    @OneToOne
    @MapsId
    @JoinColumn(name = "charge_id", nullable = false)
    private Charge charge;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;


}
