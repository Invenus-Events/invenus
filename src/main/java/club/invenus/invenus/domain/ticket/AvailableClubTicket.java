package club.invenus.invenus.domain.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "available_club_ticket")
public class AvailableClubTicket extends AvailableTicket {

    @Column(name = "date", nullable = false)
    private LocalDate date;

}
