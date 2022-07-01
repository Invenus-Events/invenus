package club.invenus.invenus.domain.payment;

import club.invenus.invenus.domain.ticket.AvailableTicket;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "charge")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "charge_id", nullable = false)
    private UUID chargeId;

    @Column(name = "stripe_id", nullable = false)
    private String stripeId;

    @Column(name = "timestamp", nullable = false)
    @CreationTimestamp
    private ZonedDateTime timestamp;

    @Column(name = "amountSubtotal", nullable = false)
    private BigDecimal amountSubtotal;

    @Column(name = "amountTotal", nullable = false)
    private BigDecimal amountTotal;

    @OneToMany
    @ToString.Exclude
    @Builder.Default
    private List<AvailableTicket> cart = new ArrayList<>();

}
