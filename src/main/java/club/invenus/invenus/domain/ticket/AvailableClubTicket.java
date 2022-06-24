package club.invenus.invenus.domain.ticket;

import club.invenus.invenus.domain.club.Club;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "available_club_ticket")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@NoArgsConstructor
public class AvailableClubTicket extends AvailableTicket {

    @OneToOne(mappedBy = "ticket")
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(name = "date", nullable = false)
    private LocalDate date;

}
