package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.profile.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class BaseTicket {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Embedded
    private User user;


}
