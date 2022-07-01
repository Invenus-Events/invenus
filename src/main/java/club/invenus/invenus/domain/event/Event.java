package club.invenus.invenus.domain.event;

import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.media.Media;
import club.invenus.invenus.domain.rating.RatingCollection;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "event")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private UUID eventId;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @Nullable
    @Column(name = "organizer")
    private String organizer;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "sold")
    private int sold;

    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_collection_id")
    @Builder.Default
    private RatingCollection ratingCollection = new RatingCollection();

    @Embedded
    @Builder.Default
    private Media media = new Media();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<EventInstance> eventInstances = new ArrayList<>();

}
