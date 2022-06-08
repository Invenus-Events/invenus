package club.domain.event;

import club.domain.club.Club;
import club.domain.media.Media;
import club.domain.rating.RatingCollection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "tickets")
    private int sold;

    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_collection_id")
    private RatingCollection ratingCollection;

    @Embedded
    private Media media;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @JoinColumn(name = "event_instance_id")
    @ToString.Exclude
    private List<EventInstance> eventInstances = new ArrayList<>();

}
