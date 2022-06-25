package club.invenus.invenus.domain.ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "available_ticket")
@Inheritance(strategy = InheritanceType.JOINED)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AvailableTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "available_ticket_id")
    private UUID availableTicketId;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
