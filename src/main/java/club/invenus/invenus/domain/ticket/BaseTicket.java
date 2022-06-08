package club.invenus.invenus.domain.ticket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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


}
