package club.invenus.invenus;

import club.invenus.invenus.domain.Address;
import club.invenus.invenus.domain.Location;
import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.club.PriceRange;
import club.invenus.invenus.domain.media.Media;
import club.invenus.invenus.domain.profile.ClubProfile;
import club.invenus.invenus.domain.rating.RatingCollection;
import lombok.Builder;

import java.util.ArrayList;

@Builder
class ClubBuilder {

    private String address;
    @Builder.Default
    private String city = "Munich";
    @Builder.Default
    private int postCode = 80538;
    @Builder.Default
    private String country = "Germany";

    private float lat;
    private float lon;

    private String website;
    private String media;
    private String email;
    private String phone;
    private String description;
    private PriceRange priceRange;

    private String name;
    private String shortName;

    public Club toClub() {
        Address address = Address.builder()
                .address(this.address)
                .city(this.city)
                .postCode(this.postCode)
                .country(this.country)
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(this.lat)
                .longitude(this.lon)
                .build();

        Media media = new Media();
        media.setOverwrite(this.media);

        ClubProfile clubProfile = ClubProfile.builder()
                .website(this.address)
                .email(this.email)
                .phoneNumber(this.phone)
                .description(this.description)
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(media)
                .priceRange(priceRange)
                .build();

        Club club = Club.builder()
                .name(name)
                .shortName(shortName)
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }
}
