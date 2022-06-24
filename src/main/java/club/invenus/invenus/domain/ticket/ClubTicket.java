package club.invenus.invenus.domain.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "club_ticket")
public class ClubTicket extends BaseTicket {

    @Column(name = "date", nullable = false)
    private Date date;

}
