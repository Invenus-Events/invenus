package club.invenus.invenus.domain.profile;

import club.invenus.invenus.domain.Genre;
import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.club.PriceRange;
import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.media.Media;
import club.invenus.invenus.domain.rating.RatingCollection;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "club_profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubProfile {

    @Id
    @Column(name = "club_id")
    private UUID clubId;

    @MapsId
    @OneToOne(mappedBy = "profile")
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(name = "website")
    private String website;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "club_profile_genre", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "genres")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<Genre> genres = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_collection_id")
    @Builder.Default
    private RatingCollection ratingCollection = new RatingCollection();

    @Embedded
    @Builder.Default
    private Media media = new Media();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<Event> events = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "price_range")
    private PriceRange priceRange;

}
