package club.invenus.invenus.service.dto;

import club.invenus.invenus.domain.Genre;
import club.invenus.invenus.domain.Location;
import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.club.PriceRange;
import club.invenus.invenus.domain.profile.ClubProfile;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
public class ClubDTO {

    // TODO: ADD CONSTRAINTS
    private final UUID id;

    private final String name;

    private final String shortName;

    private final Location location;

    private final String website;

    private final String email;

    private final String phoneNumber;

    private final String description;

    private final List<Genre> genres;

    // TODO: RATING COLLECTION

    private final String imageUrl;

    private final PriceRange priceRange;

    public ClubDTO(@NotNull Club club) {
        var profile = club.getProfile();

        this.id = club.getClubId();
        this.name = club.getName();
        this.shortName = club.getShortName();
        this.location = club.getLocation();
        this.website = profile.getWebsite();
        this.email = profile.getEmail();
        this.phoneNumber = profile.getPhoneNumber();
        this.description = profile.getDescription();
        this.genres = profile.getGenres();
        this.imageUrl = profile.getMedia().getURL();
        this.priceRange = profile.getPriceRange();
    }

}
