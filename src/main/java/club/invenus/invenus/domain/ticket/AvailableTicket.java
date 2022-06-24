package club.invenus.invenus.domain.ticket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "available_ticket")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class AvailableTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "available_ticket_id", nullable = false)
    private UUID available_ticket_id;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
