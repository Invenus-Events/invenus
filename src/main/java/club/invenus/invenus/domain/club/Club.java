package club.invenus.invenus.domain.club;

import club.invenus.invenus.domain.Location;
import club.invenus.invenus.domain.profile.ClubProfile;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "club")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "club_id")
    private UUID clubId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "short_name")
    private String shortName;

    @Embedded
    private Location location;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn
    @NotNull
    private ClubProfile profile;

}
