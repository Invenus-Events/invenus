package club.domain.event;

import club.domain.club.Club;
import club.domain.media.Media;
import club.domain.rating.RatingCollection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
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

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "tickets")
    private int sold;

    @Column(name = "price")
    private double price;

    @Column(name = "rating")
    private RatingCollection rating;

    @Embedded
    private Media media;

}
