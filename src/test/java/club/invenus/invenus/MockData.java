package club.invenus.invenus;

import club.invenus.invenus.domain.Address;
import club.invenus.invenus.domain.Location;
import club.invenus.invenus.domain.TimeFrame;
import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.club.PriceRange;
import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.event.EventInstance;
import club.invenus.invenus.domain.media.Media;
import club.invenus.invenus.domain.profile.ClubProfile;
import club.invenus.invenus.domain.profile.DJ;
import club.invenus.invenus.domain.rating.RatingCollection;
import club.invenus.invenus.domain.ticket.AvailableEventTicket;
import com.stripe.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static Club p1Club() {
        Address address = Address.builder()
                .address("Prinzregentenstraße 1")
                .city("Munich")
                .postCode(80538)
                .country("Germany")
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(48.1444649f)
                .longitude(11.5853152f)
                .build();

        ClubProfile clubProfile = ClubProfile.builder()
                .website("https://p1-club.de")
                .email("contact@p1-club.de")
                .phoneNumber("089 2111140")
                .description("P1 Club Description")
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(new Media())
                .priceRange(PriceRange.EXPENSIVE)
                .build();

        Club club = Club.builder()
                .name("P1 Club")
                .shortName("P1")
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }

    public static Club melusinaClub() {
        Address address = Address.builder()
                .address("145 Rue de la Tour Jacob")
                .city("Luxembourg City")
                .postCode(1831)
                .country("Luxembourg")
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(49.61141454f)
                .longitude(6.1367463f)
                .build();

        Media media = new Media();
        media.setOverwrite("https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg");

        ClubProfile clubProfile = ClubProfile.builder()
                .website("https://melusina.lu")
                .email("contact@melusina.lu")
                .phoneNumber("+352 26 00 89 75")
                .description("Melusina Club Description")
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(media)
                .priceRange(PriceRange.MEDIUM)
                .build();

        Club club = Club.builder()
                .name("Melusina")
                .shortName("Melusina")
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }

    public static Club pacha() {
        Address address = Address.builder()
                .address("Maximilliansplatz 5")
                .city("Munich")
                .postCode(80333)
                .country("Germany")
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(48.1420809f)
                .longitude(11.5697679f)
                .build();

        Media media = new Media();
        media.setOverwrite("https://www.tz.de/bilder/2018/04/03/9745635/249205232-zu-muenchens-beste-bars-clubs-von-tom-osswald-2kdjclFoETec.jpg");

        ClubProfile clubProfile = ClubProfile.builder()
                .website("https://www.pacha-muenchen.de/de/")
                .email("club@pacha-muenchen.de")
                .phoneNumber("+49 89 30 90 50 85")
                .description("Pacha Club Description")
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(media)
                .priceRange(PriceRange.MEDIUM)
                .build();

        Club club = Club.builder()
                .name("Pacha")
                .shortName("Pacha")
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }

    public static Club nulle() {
        Address address = Address.builder()
                .address("Maximilliansplatz 5")
                .city("Munich")
                .postCode(80333)
                .country("Germany")
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(48.1421372f)
                .longitude(11.5699098f)
                .build();

        Media media = new Media();
        media.setOverwrite("https://www.klikcup.com/images/objects/1988/089-bar-munich.jpg");

        ClubProfile clubProfile = ClubProfile.builder()
                .website("https://089-bar.de/")
                .email("office@089-bar.de")
                .phoneNumber("+49 89 59 98 88 90")
                .description("089 Bar Description")
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(media)
                .priceRange(PriceRange.MEDIUM)
                .build();

        Club club = Club.builder()
                .name("089 Bar")
                .shortName("Nulle")
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }

    public static Club blitz() {
        Address address = Address.builder()
                .address("Museumsinsel 1")
                .city("Munich")
                .postCode(80538)
                .country("Germany")
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(48.1314923f)
                .longitude(11.585991f)
                .build();

        Media media = new Media();
        media.setOverwrite("https://www.baunetzwissen.de/imgs/2/2/0/1/5/0/6/Blitz_Club_Muenchen-2baa8b01cfd7f367.jpg");

        ClubProfile clubProfile = ClubProfile.builder()
                .website("https://www.blitz.club/")
                .email("kontakt@blitz.club")
                .phoneNumber("+49 89 38 01 26 561")
                .description("089 Bar Description")
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(media)
                .priceRange(PriceRange.EXPENSIVE)
                .build();

        Club club = Club.builder()
                .name("BLITZ Club")
                .shortName("Blitz")
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }

    public static Club neuraum() {
        Address address = Address.builder()
                .address("Arnulfstraße 17")
                .city("Munich")
                .postCode(80335)
                .country("Germany")
                .build();

        Location location = Location.builder()
                .address(address)
                .latitude(48.1422602f)
                .longitude(11.5484573f)
                .build();

        Media media = new Media();
        media.setOverwrite("https://neuraum.de/templates/yootheme/cache/FotoGalleryUploads-9a6246eb.jpeg");

        ClubProfile clubProfile = ClubProfile.builder()
                .website("https://neuraum.de/")
                .email("info@neuraum.de")
                .phoneNumber("+49 89 38 15 38 999")
                .description("Neuraum Club Description")
                .genres(new ArrayList<>())
                .ratingCollection(new RatingCollection())
                .media(media)
                .priceRange(PriceRange.MEDIUM)
                .build();

        Club club = Club.builder()
                .name("Neuraum")
                .shortName("Neuraum")
                .location(location)
                .profile(clubProfile)
                .build();

        clubProfile.setClub(club);
        return club;
    }

    public static Event p1Sommerfest() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 6, 22, 22, 0, 0),
                        LocalDateTime.of(2022, 6, 23, 4, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(20.00));

        Media media = new Media();
        media.setOverwrite("https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/Website-Event.jpg");

        return Event.builder()
                .organizer("P1 Club")
                .title("P1 SOMMERFEST 2022")
                .description("Das P1 Sommerfest verschlägt uns in die Weiten des Ozeans: auf Luao Islands. Gemeinsam mit dir erkunden wir den „Aloha Spirit“ mit tropischen Melodien und vielen weiteren Überraschungen!")
                .capacity(100)
                .sold(0)
                .price(BigDecimal.valueOf(10))
                .ratingCollection(new RatingCollection())
                .media(media)
                .eventInstances(List.of(eventInstance))
                .build();
    }

    public static Event melusinaTequilaNight() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 6, 3, 22, 0, 0),
                        LocalDateTime.of(2022, 6, 4, 4, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.TEN);

        Media media = new Media();
        media.setOverwrite("https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg");

        Event event = Event.builder()
                .organizer("Melusina")
                .title("Tequila Night 03.06.2022")
                .description("\uD83C\uDF4BTEQUILA NIGHT \uD83C\uDF4B")
                .capacity(100)
                .sold(0)
                .price(BigDecimal.valueOf(20))
                .ratingCollection(new RatingCollection())
                .media(media)
                .eventInstances(List.of(eventInstance))
                .build();

        eventInstance.setEvent(event);

        return event;
    }

    public static Event p1PackMas() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 6, 22, 22, 0, 0),
                        LocalDateTime.of(2022, 6, 23, 4, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(20.00));

        Media media = new Media();
        media.setOverwrite("https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/P1-Afterwiesn-3.jpg");

        Event event = Event.builder()
                .organizer("P1 Club")
                .title("Pack Ma's! - Wiesn 2022")
                .description("Zwei Jahre keine Wiesn, kein Gspusi, kein süffiges Festbier… Doch das Warten hat ein Ende und das größte Volksfest der Welt ist zurück!")
                .capacity(100)
                .sold(0)
                .price(BigDecimal.valueOf(15))
                .ratingCollection(new RatingCollection())
                .media(media)
                .eventInstances(List.of(eventInstance))
                .build();
        eventInstance.setEvent(event);

        return event;
    }

    public static DJ dj() {
        return new DJ();
    }
}
