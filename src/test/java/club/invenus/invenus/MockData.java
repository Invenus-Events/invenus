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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static Club p1Club() {
        return ClubBuilder.builder()
                .name("P1 Club")
                .shortName("P1")
                .website("https://www.p1-club.de")
                .email("contact@p1-club.de")
                .phone("089 2111140")
                .description("P1 Club Description")
                .media("TODO")
                .priceRange(PriceRange.EXPENSIVE)
                .address("Prinzregentenstraße 1")
                .lat(48.1444649f)
                .lon(11.5853152f)
                .build().toClub();
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
        return EventBuilder.builder()
                .organizer("P1 Club")
                .title("P1 SOMMERFEST 2022")
                .description("Das P1 Sommerfest verschlägt uns in die Weiten des Ozeans: auf Luao Islands. Gemeinsam mit dir erkunden wir den „Aloha Spirit“ mit tropischen Melodien und vielen weiteren Überraschungen!")
                .media("https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/Website-Event.jpg")
                .month(8)
                .dayStart(22)
                .hourStart(22)
                .dayEnd(23)
                .hourEnd(4)
                .price(20.00)
                .build().toEvent();
    }

    public static Event melusinaTequilaNight() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 9, 3, 22, 0, 0),
                        LocalDateTime.of(2022, 9, 4, 4, 0, 0)))
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

    public static Event pachaFreitag() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 7, 15, 22, 0, 0),
                        LocalDateTime.of(2022, 7, 16, 4, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(15.00));

        Media media = new Media();
        media.setOverwrite("https://www.mucbook.de/wp-content/uploads/2019/10/Jaegermeister_Tablesfor2_KickOff_6.jpg");

        Event event = Event.builder()
                .organizer("Pacha")
                .title("FreitagNacht w/ Mathame, Stefanie Raschke")
                .description("Wir empfehlen, vor dem Clubbesuch einen Corona-Selbsttest zu machen und bei Krankheitssymptomen Zuhause zu bleiben. Wir alle sollten uns weiterhin schützen und Rücksicht nehmen. Danke!")
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

    public static Event blitzAftershow() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 7, 23, 23, 0, 0),
                        LocalDateTime.of(2022, 7, 24, 6, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(15.00));

        Media media = new Media();
        media.setOverwrite("http://retaildesignblog.net/wp-content/uploads/2017/10/Blitz-Music-CLub-by-STUDIO-KNACK-AND-SIMON-VORHAMMER-Munich-Germany.jpg");

        Event event = Event.builder()
                .organizer("Blitz Club")
                .title("SCHALL IM SCHILF AFTERSHOW")
                .description("Set times for the weekends are published every Friday noon at www.blitz.club. PLEASE RESPECT OUR NO PHOTO POLICY! NO PHONES ON THE DANCE FLOORS! BE WHO YOU ARE! LOVE IS THE MESSAGE!")
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

    public static Event neuraumClubSound() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 8, 6, 22, 0, 0),
                        LocalDateTime.of(2022, 8, 7, 6, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(12.00));

        Media media = new Media();
        media.setOverwrite("https://www.my-private.club/images/eventdates/info/50476.jpg");

        Event event = Event.builder()
                .organizer("Neuraum")
                .title("Mashup Baby - Clubsound 2.0 w/ Crunkz")
                .description("Crunkz macht derzeit in der deutschen DJ-Szene ordentlich von sich Reden. Der 25-Jährige hat sich innerhalb von kürzester Zeit auch weit über die Landesgrenzen hinaus einen Namen gemacht. Angefangen mit Mixes auf YouTube geht es für den DJ und Producer seitdem kontinuierlich nach oben. Inzwischen begeistert er auch auf Soundcloud, Instagram & Co. mit seinen Tracks und Mashups nicht nur mehr als 700.000 Fans, sondern auch Stars der Szene wie Tiesto, Hardwell, Dash Berlin und viele mehr.\n" +
                        "Aber Crunkz vereint seine Fans nicht nur in den sozialen Medien, sondern auch offline auf der Tanzfläche. Shows in Clubs von Weltrang wie dem Kölner Bootshaus und dem Münchner Neuraum und Mainstage-Gigs wie beim Open Beatz Festival haben bereits gezeigt, dass Crunkz die Zukunft gehört.\n" +
                        "Crunkz wahre Leidenschaft ist aber das Produzieren, der Grind im Studio, das endlose Verbessern und Perfektionieren der eigenen musikalischen Werke. Das Gefühl für Rhythmus und Melodien wurde dem Spross einer musikalischen Familie quasi in die Wiege gelegt. Diese Talente bleiben nicht unentdeckt, schon 2018 findet sich Crunkz auf Hardwells Label Revealed Recordings wieder.\n" +
                        "Viel wichtiger ist für den jungen Produzenten aber der künstlerische Aha-Moment, das Entdecken des eigenen Sounds. Der Output der letzten Jahre zeigt, dass Crunkz fündig geworden ist. Mit seinen neuesten Tracks geht er musikalisch einen ganz neuen Weg.\n" +
                        "Frische House Music mit eingängigen Vocals und raumfüllenden Sounds – schon jetzt ein absolutes Erfolgsrezept. Egal ob „Superlike“, „Memories“ oder „I Don’t Wanna Know”:\n" +
                        "Sie alle begeistern dank ihrer geheimnisvollen Atmosphäre, treibenden Bässe und der anziehenden Lyrics. Dem kreativen Schaffen des Youngsters scheinen einfach keine Grenzen gesetzt zu sein.\n" +
                        "Crunkz sollte man definitiv auf dem Zettel haben!\n")
                .capacity(100)
                .sold(0)
                .price(BigDecimal.valueOf(12))
                .ratingCollection(new RatingCollection())
                .media(media)
                .eventInstances(List.of(eventInstance))
                .build();
        eventInstance.setEvent(event);

        return event;
    }

    public static Event nulleSommerfest() {
        AvailableEventTicket eventTicket = new AvailableEventTicket();
        EventInstance eventInstance = EventInstance.builder()
                .timeFrame(new TimeFrame(LocalDateTime.of(2022, 7, 16, 18, 0, 0),
                        LocalDateTime.of(2022, 7, 17, 2, 0, 0)))
                .ticket(eventTicket)
                .build();
        eventTicket.setEventInstance(eventInstance);
        eventTicket.setPrice(BigDecimal.valueOf(10.00));

        Media media = new Media();
        media.setOverwrite("https://www.kuffler.de/thumbs/6673_5_01-Bar-am-SeeHaus-Chefs-Table.jpg");

        Event event = Event.builder()
                .organizer("089 Bar")
                .title("089 Sommerfest")
                .description("in der Bar am See/Haus!")
                .capacity(100)
                .sold(0)
                .price(BigDecimal.valueOf(10))
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
