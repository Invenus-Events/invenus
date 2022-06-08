package club.invenus.invenus.domain.ticket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "event ticket")
@Getter
@Setter
public class EventTicket extends BaseTicket {



}
