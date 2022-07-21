package club.invenus.invenus.domain.rating;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "rating_collection")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@ToString
public class RatingCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_collection_id")
    private int ratingCollectionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "google_ratings_id")
    private Ratings googleRatings = new Ratings();


}
