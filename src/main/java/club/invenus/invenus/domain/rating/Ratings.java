package club.invenus.invenus.domain.rating;

import club.invenus.invenus.domain.event.Event;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "rating")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ratings_id")
    private int ratingsId;

    @ManyToOne
    @JoinColumn(name = "rating id")
    private List<Rating> ratings = new ArrayList<>();

}
