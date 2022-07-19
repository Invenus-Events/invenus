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

    // *****************************************************************************************************************
    // Clubs 27
    // *****************************************************************************************************************

        // *************************************************************************************************************
        // Munich clubs: 5
        // *************************************************************************************************************
        public static Club p1Club() {
            return ClubBuilder.builder()
                    .name("P1 Club")
                    .shortName("P1")
                    .website("https://www.p1-club.de")
                    .email("contact@p1-club.de")
                    .phone("089 2111140")
                    .description("P1 Club Description")
                    .media("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/51/5b/92/mit-dem-letzten-grossen.jpg?w=1200&h=-1&s=1.jpeg")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("Prinzregentenstraße 1")
                    .lat(48.1444649f)
                    .lon(11.5853152f)
                    .build().toClub();
        }

        public static Club pacha() {
            return ClubBuilder.builder()
                    .name("Pacha")
                    .shortName("Pacha")
                    .website("https://www.pacha-muenchen.de/de/")
                    .email("club@pacha-muenchen.de")
                    .phone("+49 89 30 90 50 85")
                    .description("Pacha Club Description")
                    .media("https://www.tz.de/bilder/2018/04/03/9745635/249205232-zu-muenchens-beste-bars-clubs-von-tom-osswald-2kdjclFoETec.jpg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("Maximilliansplatz 5")
                    .city("Munich")
                    .postCode(80333)
                    .country("Germany")
                    .lat(48.1420809f)
                    .lon(11.5697679f)
                    .build().toClub();
        }

        public static Club nulle() {
            return ClubBuilder.builder()
                    .name("089 Bar")
                    .shortName("Nulle")
                    .website("https://089-bar.de/")
                    .email("office@089-bar.de")
                    .phone("+49 89 59 98 88 9")
                    .description("089 Bar Description")
                    .media("https://www.klikcup.com/images/objects/1988/089-bar-munich.jpg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("Maximilliansplatz 5")
                    .city("Munich")
                    .postCode(80333)
                    .country("Germany")
                    .lat(48.1421372f)
                    .lon(11.5699098f)
                    .build().toClub();
        }

        public static Club blitz() {
            return ClubBuilder.builder()
                    .name("BLITZ Club")
                    .shortName("BLITZ")
                    .website("https://www.blitz.club/")
                    .email("kontakt@blitz.club")
                    .phone("+49 89 38 01 26 561")
                    .description("Blitz Club Description")
                    .media("https://www.baunetzwissen.de/imgs/2/2/0/1/5/0/6/Blitz_Club_Muenchen-2baa8b01cfd7f367.jpg")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("Museumsinsel 1")
                    .city("Munich")
                    .postCode(80538)
                    .country("Germany")
                    .lat(48.1314923f)
                    .lon(11.585991f)
                    .build().toClub();
        }

        public static Club neuraum() {
            return ClubBuilder.builder()
                    .name("Neuraum")
                    .shortName("Neuraum")
                    .website("https://neuraum.de/")
                    .email("info@neuraum.de")
                    .phone("+49 89 38 15 38 999")
                    .description("Neuraum Club Description")
                    .media("https://neuraum.de/templates/yootheme/cache/FotoGalleryUploads-9a6246eb.jpeg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("Arnulfstraße 17")
                    .city("Munich")
                    .postCode(80335)
                    .country("Germany")
                    .lat(48.1422602f)
                    .lon(11.5484573f)
                    .build().toClub();
        }
        // *************************************************************************************************************
        // Luxembourg clubs: 2
        // *************************************************************************************************************
        public static Club melusinaClub() {
            return ClubBuilder.builder()
                    .name("Melusina")
                    .shortName("Melusina")
                    .website("https://melusina.lu")
                    .email("contact@melusina.lu")
                    .phone("+352 26 00 89 75")
                    .description("Melusina Club Description")
                    .media("https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("145 Rue de la Tour Jacob")
                    .city("Luxembourg City")
                    .postCode(1831)
                    .country("Luxembourg")
                    .lat(49.61141454f)
                    .lon(6.1367463f)
                    .build().toClub();
        }

        public static Club Rockhal() {
            return ClubBuilder.builder()
                    .name("Rockhal")
                    .shortName("Rockhal")
                    .website("https://www.rockhal.lu/")
                    .email("info@rockhal.lu")
                    .phone("+352 24 55 51")
                    .description("Where music matters")
                    .media("https://www.eventtravel.com/upload/images/seating_plans_2022/rockhal-luxembourg.jpg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("5 Av. du Rock'n'Roll")
                    .city("Luxembourg City")
                    .postCode(4083)
                    .country("Luxembourg")
                    .lat(49.4999f)
                    .lon(5.9474f)
                    .build().toClub();
        }
        // *************************************************************************************************************
        // Zurich clubs: 2
        // *************************************************************************************************************
        public static Club samigoAmusement() {
            return ClubBuilder.builder()
                    .name("Samigo Amusement")
                    .shortName("Samigo Amusement")
                    .website("www.samigo.ch")
                    .email("info@samigo.ch")
                    .phone("+41 79 360 20 65")
                    .description("The party center of Zurich, hosting great parties and dishing out great experiences")
                    .media("https://www.zuerich.com/sites/default/files/styles/1216_684_focal_scale_crop/public/image/2022/web_zuerich_samigo_amusement_1280x960_41796.jpg?h=1652856908")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("Mythenquai 59")
                    .city("Zurich")
                    .postCode(8002)
                    .country("Switzerland")
                    .lat(47.35885f)
                    .lon(8.53697f)
                    .build().toClub();
        }

        public static Club clubBellevue() {
            return ClubBuilder.builder()
                    .name("Club Bellevue")
                    .shortName("Club Bellevue")
                    .website("https://club-bellevue.ch")
                    .email("welcome@club-bellevue.ch")
                    .phone("+41 44 251 33 41")
                    .description("Clubbing im Herzen von Zürich")
                    .media("https://www.zuerich.com/sites/default/files/keyvisual/web_zuerich_club_bellevue_04_1280x856.jpg")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("Freieckgasse 9")
                    .city("Zurich")
                    .postCode(8001)
                    .country("Switzerland")
                    .lat(47.367744395336274f)
                    .lon(8.546107194566307f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // Paris clubs: 2
        // *************************************************************************************************************
        public static Club rexClub() {
            return ClubBuilder.builder()
                    .name("Rex Club")
                    .shortName("Rex")
                    .website("https://rexclub.com/?lang=en")
                    .email("infos@rexclub.com")
                    .phone("+33 1 42 36 10 96")
                    .description("Rex Club: 33 years of electronic music")
                    .media("https://rexclub.com/wp-content/uploads/2020/11/20201127-slide-home-rex-club.jpg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("5 Bd Poissonnière")
                    .city("Paris")
                    .postCode(75002)
                    .country("France")
                    .lat(49.19876120583433f)
                    .lon(2.4561645209773983f)
                    .build().toClub();
        }

        public static Club petitBain() {
            return ClubBuilder.builder()
                    .name("Petit Bain")
                    .shortName("Petit Bain")
                    .website("https://petitbain.org")
                    .email("objetperdu@petitbain.org")
                    .phone("+33 1 42 36 10 95")
                    .description("Salle de concert & club mais aussi restaurant/bar avec toit-terrasse au bord de l’eau, le tout flottant sur la Seine.")
                    .media("https://foodetective-production.s3.amazonaws.com/uploads/picture/photo/a66f7dfc-44bb-4e86-b686-033fffc3cffd/photo.jpeg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("7 Port de la Gare")
                    .city("Paris")
                    .postCode(75013)
                    .country("France")
                    .lat(48.835515707052366f)
                    .lon(2.376723128771696f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // New York clubs: 3
        // *************************************************************************************************************
        public static Club paradiseClub() {
            return ClubBuilder.builder()
                    .name("Paradise Club")
                    .shortName("Paradise Club")
                    .website("https://theparadiseclubnyc.com")
                    .email("info@paradiseClubnyc.org")
                    .phone("+1 212-261-5400")
                    .description("BRINGING WILD, HIGH-ENERGY GLAMOUR TO TIMES SQUARE, IN PARTNERSHIP BETWEEN STUDIO 54’S IAN SCHRAGER AND RESTAURATEUR & MICHELIN-STARRED CHEF JOHN FRASER. SIGNATURE NIGHTLY PARTIES EVERY WEEK.")
                    .media("https://images.squarespace-cdn.com/content/v1/5324ccfce4b00257d64240f2/1596936168873-PY860LII8DAVG5EVGOY2/web.paradise0075.jpg?format=1500w")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("20 Times Square, 701 7th Ave")
                    .city("New York")
                    .postCode(10036)
                    .country("United States")
                    .lat(40.759290395966644f)
                    .lon(-73.984154731044f)
                    .build().toClub();
        }

        public static Club musicaClubNYC() {
            return ClubBuilder.builder()
                    .name("Musica Club NYC")
                    .shortName("Musica Club NYC")
                    .website("https://musicaclubs.com/")
                    .email("media.us@musicaclubs.com")
                    .phone("+1 212-747-1007")
                    .description("Musica Club is now coming to New York. Musica is born from a partnership between Giuseppe Cipriani and Italian nightlife entrepreneur Tito Pinton, owner of the historic Il Muretto club in Italy")
                    .media("https://media.timeout.com/images/105894445/750/422/image.jpg")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("637 W 50th St")
                    .city("New York")
                    .postCode(10019)
                    .country("United States")
                    .lat(40.76681793672255f)
                    .lon(-73.99617547325033f)
                    .build().toClub();
        }

        public static Club theIridium() {
            return ClubBuilder.builder()
                    .name("The Iridium")
                    .shortName("The Iridium")
                    .website("https://www.theiridium.com")
                    .email("mjfaith@jfaith.com")
                    .phone("+1 212-582-2121")
                    .description("Intimate basement jazz club long associated with Les Paul that features national & local performers.")
                    .media("https://cdn.vox-cdn.com/thumbor/CUL_vd4eIvJUsnug6F9wVErWwIY=/0x0:960x716/920x613/filters:focal(404x282:556x434):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/60890073/akY9DWv_eNpsqkt7DObRVWoeyQ8fMXaKJuOc7uR5GZY.0.jpg")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("1650 Broadway")
                    .city("New York")
                    .postCode(10019)
                    .country("United States")
                    .lat(40.76194473732887f)
                    .lon(-73.98353573092089f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // Berlin clubs: 2
        // *************************************************************************************************************
        public static Club Berghain() {
            return ClubBuilder.builder()
                    .name("Berghain | Panorama Bar")
                    .shortName("Berghain")
                    .website("https://www.berghain.berlin/en/")
                    .email("support@berghain.de")
                    .phone("030 29 36 02 10")
                    .description("Take Care of Yourself and Your Friends")
                    .media("https://news.artnet.com/app/news-upload/2020/08/GettyImages-1259150273-1024x683.jpg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("Am Wriezener bhf")
                    .city("Berlin")
                    .postCode(10243)
                    .country("Germany")
                    .lat(52.5111f)
                    .lon(13.4430f)
                    .build().toClub();
        }

        public static Club YAAM() {
            return ClubBuilder.builder()
                    .name("YAAM")
                    .shortName("YAAM")
                    .website("https://www.yaam.de/")
                    .email("info@yaam.de.")
                    .phone("0176 10051189")
                    .description("Riverside beach club with basketball & volleyball courts, a bar plus live concerts & music from DJs.")
                    .media("https://i0.wp.com/www.yaam.de/wp-content/uploads/2022/01/yaam-beach-berlin-slide-scaled.jpg?resize=1160%2C650&ssl=1")
                    .priceRange(PriceRange.CHEAP)
                    .address("AAn d. Schillingbrücke 3")
                    .city("Berlin")
                    .postCode(10243)
                    .country("Germany")
                    .lat(52.5093f)
                    .lon(13.4305f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // Copenhagen clubs: 2
        // *************************************************************************************************************
        public static Club gayCopenhagenNightclub() {
            return ClubBuilder.builder()
                    .name("G*A*Y Copenhagen Nightclub")
                    .shortName("G*A*Y Copenhagen Nightclub")
                    .website("https://www.facebook.com/gaycopenhagennightclub/")
                    .email("gaycph@gmail.com")
                    .phone("+45-415-556-00")
                    .description("G*A*Y Copenhagen is a LGBTQIA+ bar located in the heart of Copenhagen.")
                    .media("https://scontent-frx5-1.xx.fbcdn.net/v/t1.6435-9/61756303_3277857768906332_7894931462426722304_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=e3f864&_nc_ohc=2BOpHuh8uqcAX-ot4TF&_nc_oc=AQl7GNlbnoUS2_EvGt8p6NtMYNGi-Ub8KeADuMLfXwqKwIqFOXPqLqcqZAsfe267vdsgeJyxFLlxHMZYkt8lSh7Y&_nc_ht=scontent-frx5-1.xx&oh=00_AT_N8XcaVAoCCkfCQWwQSo2e3EzbjI9nWbRhPJ2XfhwVlg&oe=62EDD37D")
                    .priceRange(PriceRange.CHEAP)
                    .address("Vester Voldgade 10")
                    .city("Copenhagen")
                    .postCode(1552)
                    .country("Denmark")
                    .lat(55.677632764082354f)
                    .lon(12.568678806769947f)
                    .build().toClub();
        }

        public static Club hiveCopenhagen() {
            return ClubBuilder.builder()
                    .name("Hive")
                    .shortName("Hive")
                    .website("https://hivecph.dk")
                    .email("info@hivecph.dk")
                    .phone("+45 31 73 73 07")
                    .description("HIVE is a high-end nightclub providing VIP table and bottle service, with international standards and a level of service rarely seen in Copenhagen. " +
                            "Since HIVE opened in 2012 the ambition has been to push the limits and make way for our vision, driven by passion and the ambition to be Copenhagen’s leading high-end nightclub. " +
                            "No other high-end nightclub in Copenhagen has existed for as long as HIVE. An established icon of its time, HIVE has become a symbol of the exclusive nightlife in Copenhagen and a frontrunner in the industry")
                    .media("https://mag.soundclub.com/wp-content/uploads/2022/03/Copenhagen_Hive-1024x683.jpg")
                    .priceRange(PriceRange.MEDIUM)
                    .address("Skindergade 45")
                    .city("Copenhagen")
                    .postCode(1159)
                    .country("Denmark")
                    .lat(55.6786f)
                    .lon(12.5730f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // Shanghai clubs: 2
        // *************************************************************************************************************
        public static Club M1NT() {
            return ClubBuilder.builder()
                    .name("M1NT")
                    .shortName("M1NT")
                    .website("https://www.facebook.com/M1NTShanghai/")
                    .email("bookings@m1ntshanghai.com")
                    .phone("+86 21 6391 2811")
                    .description("\n" +
                            "M1NT is a party spot in Shanghai. A hip and stylish nightclub, perched on the 24th floor high above Shanghai, with dramatic floor-to-ceiling windows offering spectacular 360° views of the Bund, Pudong, " +
                            "Nanjing Road, People's Square and Huaihai Road. The first thing you notice upon arriving at M1NT Club is the jaw-dropping 17-metre long shark tank, complete with more than 20 black and white reef-tip sharks." +
                            "\n" +
                            "It is a modern day members club for the chic, professional and classy clientele that still enjoy a great party, yet sophisticated environment. It's a glamorous destination " +
                            "where you can dine, network and party with like-minded people. Ditch those misconceptions: you won't find any stuffy old men in tweed jackets here. M1NT is a world-class destination restaurant, " +
                            "stylish cocktail lounge bar, stunning roof terrace and night club, all rolled into one with award winning services")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("318 Fuzhou Rd, Huangpu")
                    .city("Shanghai")
                    .postCode(200001)
                    .country("China")
                    .lat(31.231054773498546f)
                    .lon(121.47833463452282f)
                    .build().toClub();
        }

        public static Club barRouge() {
            return ClubBuilder.builder()
                    .name("Bar Rouge")
                    .shortName("Bar Rouge")
                    .website("https://barrougeclubs.com/sh/")
                    .email("contactsh@barrougeclubs.com")
                    .phone("+86 21 6339 1199")
                    .description("The opening of Bar Rouge in 2004 atop Bund 18 announced a new era in Shanghai nightlife. Rapidly becoming the city’s go-to venue, Bar Rouge offers a unique combination of high style " +
                            "and unbeatable Shanghai’s skyline views from its spacious terrace. Sexy crowds, international DJs, fantastic theme parties, and unique Champagne celebration rituals, contribute to its amazing " +
                            "ambiance night after night, becoming an icon of Shanghai’s glamorous nightlife.")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("No.18 Zhongshan Dong Yi Road,")
                    .city("Shanghai")
                    .postCode(200003)
                    .country("China")
                    .lat(31.228412610446426f)
                    .lon(121.47730466629125f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // Bangkok clubs: 2
        // *************************************************************************************************************
        public static Club Bullys() {
            return ClubBuilder.builder()
                    .name("Bully's")
                    .shortName("Bully's")
                    .website("https://www.bullys-bangkok.com/")
                    .email("pubbullys@gmail.com")
                    .phone("+66996160008")
                    .description("The true American experience!")
                    .priceRange(PriceRange.MEDIUM)
                    .address("8 Sukhumvit Rd, Khlong Toei")
                    .city("Bankik")
                    .postCode(10110)
                    .country("Thailand")
                    .lat(13.743019775937714f)
                    .lon(100.55227282844709f)
                    .build().toClub();
        }

        public static Club sugarClub() {
            return ClubBuilder.builder()
                    .name("Sugar Club")
                    .shortName("Sugar Club")
                    .website("https://www.sugarclub-bangkok.com/")
                    .email("sugarClub@gmail.com")
                    .phone("+66613913111")
                    .description("The #1 Hip Hop club in Thailand")
                    .priceRange(PriceRange.MEDIUM)
                    .address("37 Soi Sukhumvit 11, Khlong Toei Nuea, Watthana")
                    .city("Bankik")
                    .postCode(10110)
                    .country("Thailand")
                    .lat(13.74368676252214f)
                    .lon(100.55553439444083f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // LA clubs: 2
        // *************************************************************************************************************
        public static Club exchangeLA() {
            return ClubBuilder.builder()
                    .name("Exchange LA")
                    .shortName("Exchange")
                    .website("https://exchangela.com/contact/")
                    .email("INFO@EXCHANGELA.COM")
                    .phone("+12136278070")
                    .description("The best Club in LA")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("618 S Spring St")
                    .city("Los Angeles")
                    .postCode(90014)
                    .country("United States")
                    .lat(34.04709970342051f)
                    .lon(-118.25183122361082f)
                    .build().toClub();
        }

        public static Club clubCrawlLA() {
            return ClubBuilder.builder()
                    .name("Club Crawl LA")
                    .shortName("Club Crawl")
                    .website("https://losangelesclubcrawl.com")
                    .email("events@losangelesclubcrawl.com")
                    .phone("+13236676282")
                    .description("Events company organizing hosted local nightclub tours with VIP entry & drink deals.")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("830 S Broadway")
                    .city("Los Angeles")
                    .postCode(90014)
                    .country("United States")
                    .lat(34.043779546333525f)
                    .lon(-118.25525840723023f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // South Korea clubs: 2
        // *************************************************************************************************************
        public static Club soapSeoul() {
            return ClubBuilder.builder()
                    .name("Soap Seoul")
                    .shortName("Soap Seoul")
                    .website("https://soapseoul.com")
                    .email("events@sSeoul.com")
                    .phone("+827044576860")
                    .description("This dance club enhances the sensory experience with elaborate lighting, design & the latest hits.")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("132-3 Itaewon-dong Yongsan-gu Seoul KRy")
                    .city("Seoul")
                    .postCode(4346)
                    .country("South Korea")
                    .lat(37.53356727906893f)
                    .lon(126.99513219336157f)
                    .build().toClub();
        }

        public static Club hongdaeClubAura() {
            return ClubBuilder.builder()
                    .name("Hongdae Club Aura")
                    .shortName("Club Aura")
                    .website("https://linktr.ee/clubaura")
                    .email("events@ClubAura.org")
                    .phone("+82-10-6667-6460")
                    .description("This dance club provides the latest hits and the best time ever!")
                    .priceRange(PriceRange.EXPENSIVE)
                    .address("364-24 Seogyo-dong, Mapo-gu")
                    .city("Seoul")
                    .postCode(4346)
                    .country("South Korea")
                    .lat(37.552351069508696f)
                    .lon(126.92182243595664f)
                    .build().toClub();
        }

        // *************************************************************************************************************
        // Australia clubs: 1
        // *************************************************************************************************************
        public static Club clubRetro() {
            return ClubBuilder.builder()
                    .name("Club Retro")
                    .shortName("Club retro")
                    .website("https://www.clubretro.com.au")
                    .email("info@clubretro.com.au")
                    .phone("+61396706575")
                    .description("The perfect place to have your birthday party or work function!")
                    .priceRange(PriceRange.MEDIUM)
                    .address(" 383 Lonsdale St")
                    .city("Melbourne")
                    .postCode(3000)
                    .country("South Australia")
                    .lat(-37.81243616417134f)
                    .lon(144.96113780141528f)
                    .build().toClub();
        }



    // *****************************************************************************************************************
    // Events 50
    // *****************************************************************************************************************

        // *************************************************************************************************************
        // Munich Events: 6
        // *************************************************************************************************************
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

        public static Event p1PackMas() {
            return EventBuilder.builder()
                    .organizer("P1 Club")
                    .title("Pack Ma's! - Wiesn 2022")
                    .description("Wir empfehlen, vor dem Clubbesuch einen Corona-Selbsttest zu machen und bei Krankheitssymptomen Zuhause zu bleiben. Wir alle sollten uns weiterhin schützen und Rücksicht nehmen. Danke!")
                    .media("https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/P1-Afterwiesn-3.jpg")
                    .month(6)
                    .dayStart(22)
                    .hourStart(22)
                    .dayEnd(23)
                    .hourEnd(4)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event pachaFreitag() {
            return EventBuilder.builder()
                    .organizer("Pacha")
                    .title("FreitagNacht w/ Mathame, Stefanie Raschke")
                    .description("Zwei Jahre keine Wiesn, kein Gspusi, kein süffiges Festbier… Doch das Warten hat ein Ende und das größte Volksfest der Welt ist zurück!")
                    .media("https://www.mucbook.de/wp-content/uploads/2019/10/Jaegermeister_Tablesfor2_KickOff_6.jpg")
                    .month(7)
                    .dayStart(15)
                    .hourStart(22)
                    .dayEnd(16)
                    .hourEnd(4)
                    .price(15.00)
                    .build().toEvent();
        }

        public static Event blitzAftershow() {
            return EventBuilder.builder()
                    .organizer("Blitz Club")
                    .title("SCHALL IM SCHILF AFTERSHOW")
                    .description("Set times for the weekends are published every Friday noon at www.blitz.club. PLEASE RESPECT OUR NO PHOTO POLICY! NO PHONES ON THE DANCE FLOORS! BE WHO YOU ARE! LOVE IS THE MESSAGE!")
                    .media("https://retaildesignblog.net/wp-content/uploads/2017/10/Blitz-Music-CLub-by-STUDIO-KNACK-AND-SIMON-VORHAMMER-Munich-Germany.jpg")
                    .month(7)
                    .dayStart(23)
                    .hourStart(23)
                    .dayEnd(24)
                    .hourEnd(6)
                    .price(15.00)
                    .build().toEvent();
        }

        public static Event neuraumClubSound() {
            return EventBuilder.builder()
                    .organizer("Neuraum")
                    .title("Mashup Baby - Clubsound 2.0 w/ Crunkz")
                    .description("""
                            Crunkz macht derzeit in der deutschen DJ-Szene ordentlich von sich Reden. Der 25-Jährige hat sich innerhalb von kürzester Zeit auch weit über die Landesgrenzen hinaus einen Namen gemacht. Angefangen mit Mixes auf YouTube geht es für den DJ und Producer seitdem kontinuierlich nach oben. Inzwischen begeistert er auch auf Soundcloud, Instagram & Co. mit seinen Tracks und Mashups nicht nur mehr als 700.000 Fans, sondern auch Stars der Szene wie Tiesto, Hardwell, Dash Berlin und viele mehr.\\n" +
                            "Aber Crunkz vereint seine Fans nicht nur in den sozialen Medien, sondern auch offline auf der Tanzfläche. Shows in Clubs von Weltrang wie dem Kölner Bootshaus und dem Münchner Neuraum und Mainstage-Gigs wie beim Open Beatz Festival haben bereits gezeigt, dass Crunkz die Zukunft gehört.\\n" +
                            "Crunkz wahre Leidenschaft ist aber das Produzieren, der Grind im Studio, das endlose Verbessern und Perfektionieren der eigenen musikalischen Werke. Das Gefühl für Rhythmus und Melodien wurde dem Spross einer musikalischen Familie quasi in die Wiege gelegt. Diese Talente bleiben nicht unentdeckt, schon 2018 findet sich Crunkz auf Hardwells Label Revealed Recordings wieder.\\n" +
                            "Viel wichtiger ist für den jungen Produzenten aber der künstlerische Aha-Moment, das Entdecken des eigenen Sounds. Der Output der letzten Jahre zeigt, dass Crunkz fündig geworden ist. Mit seinen neuesten Tracks geht er musikalisch einen ganz neuen Weg.\\n" +
                            "Frische House Music mit eingängigen Vocals und raumfüllenden Sounds – schon jetzt ein absolutes Erfolgsrezept. Egal ob „Superlike“, „Memories“ oder „I Don’t Wanna Know”:\\n" +
                            "Sie alle begeistern dank ihrer geheimnisvollen Atmosphäre, treibenden Bässe und der anziehenden Lyrics. Dem kreativen Schaffen des Youngsters scheinen einfach keine Grenzen gesetzt zu sein.\\n" +
                            "Crunkz sollte man definitiv auf dem Zettel haben!\\n""")
                    .media("https://retaildesignblog.net/wp-content/uploads/2017/10/Blitz-Music-CLub-by-STUDIO-KNACK-AND-SIMON-VORHAMMER-Munich-Germany.jpg")
                    .month(8)
                    .dayStart(6)
                    .hourStart(22)
                    .dayEnd(7)
                    .hourEnd(6)
                    .price(12.00)
                    .build().toEvent();
        }

        public static Event nulleSommerfest() {
            return EventBuilder.builder()
                    .organizer("089 Bar")
                    .title("089 Sommerfest")
                    .description("in der Bar am See/Haus!")
                    .media("https://www.kuffler.de/thumbs/6673_5_01-Bar-am-SeeHaus-Chefs-Table.jpg")
                    .month(7)
                    .dayStart(16)
                    .hourStart(18)
                    .dayEnd(17)
                    .hourEnd(2)
                    .price(10.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Luxembourg Events: 2
        // *************************************************************************************************************
        public static Event melusinaTequilaNight() {
            return EventBuilder.builder()
                    .organizer("Melusina")
                    .title("Tequila Night 03.06.2022")
                    .description("\uD83C\uDF4BTEQUILA NIGHT \uD83C\uDF4B")
                    .media("https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg")
                    .month(9)
                    .dayStart(3)
                    .hourStart(22)
                    .dayEnd(4)
                    .hourEnd(4)
                    .price(10.00)
                    .build().toEvent();
        }

        public static Event rockhalOpenAirBelval() {
            return EventBuilder.builder()
                    .organizer("Rockhal")
                    .title("Open Air Belval")
                    .description("THE KILLERS - OPEN AIR BELVAL")
                    .media("https://static.rtlradio.de/img/4704/688482/493000/Img_2_1/1440/the_killer_2022_esch_22_rockhal.jpg")
                    .month(7)
                    .dayStart(10)
                    .hourStart(22)
                    .dayEnd(11)
                    .hourEnd(4)
                    .price(25.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Zurich Events: 2
        // *************************************************************************************************************
        public static Event sundayZHDayParty() {
            return EventBuilder.builder()
                    .organizer("Samigo Amusement")
                    .title("SUNDAYZH DAYPARTY")
                    .description("A Party playing Urban music featuring famous DJ: Restlezz Resident DJs")
                    .media("https://cdn.stayhappening.com/events1/banners/65fb99a1ff2c36aab88e1f80b424c86129819ec3f984404c0bf0c7e518a5dc30-rimg-w526-h296-gmir.jpg?v=1628195797")
                    .month(7)
                    .dayStart(10)
                    .hourStart(16)
                    .dayEnd(11)
                    .hourEnd(3)
                    .price(25.00)
                    .build().toEvent();
        }

        public static Event secretIslandAfterParty() {
            return EventBuilder.builder()
                    .organizer("Club Bellevue")
                    .title("SECRET ISLAND AFTERPARTY")
                    .description("Playing electric and house Music. Focused to give you the best night of your life")
                    .media("https://www.zuerich.com/sites/default/files/keyvisual/web_zuerich_club_bellevue_04_1280x856.jpg")
                    .month(7)
                    .dayStart(16)
                    .hourStart(22)
                    .dayEnd(17)
                    .hourEnd(5)
                    .price(30.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Paris Events: 2
        // *************************************************************************************************************
        public static Event rexClubBakermatMat() {
            return EventBuilder.builder()
                    .organizer("Rex Club")
                    .title("Rex Club Présente: Bakermat & Mat Ld")
                    .description("Introducing famous DJs Bakermat and Mat Ld. A night filled with house music and fun")
                    .media("https://images.xceed.me/events/banners/rex-club-presente-bakermat-mat-ld-paris-xceed.jpg?w=920&ar=16:9&fm=auto")
                    .month(7)
                    .dayStart(22)
                    .hourStart(20)
                    .dayEnd(23)
                    .hourEnd(5)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event festivalDesSouvenirsBrises() {
            return EventBuilder.builder()
                    .organizer("Petit Bain")
                    .title("Festival des Souvenirs Brisés")
                    .description("Un Festival Gothique organisé par Intervision avec deux salles dans lesquelles pleurer.")
                    .media("https://images.xceed.me/events/banners/festival-des-souvenirs-brises-paris-xceed.jpg?w=920&ar=16:9&fm=auto")
                    .month(8)
                    .dayStart(4)
                    .hourStart(22)
                    .dayEnd(5)
                    .hourEnd(3)
                    .price(15.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // New York City Events: 6
        // *************************************************************************************************************
        public static Event paradiseClubHighFligher() {
            return EventBuilder.builder()
                    .organizer("Paradise Club")
                    .title("High Fligher Dine in")
                    .description("A night of music and fun to jumpstart your weekend")
                    .media("https://mag.soundclub.com/wp-content/uploads/2022/06/@ParadiseClubNyc_Facebook1-1024x683.jpg")
                    .month(9)
                    .dayStart(10)
                    .hourStart(19)
                    .dayEnd(11)
                    .hourEnd(24)
                    .price(65.00)
                    .build().toEvent();
        }

        public static Event paradiseClubJazzNightOut() {
            return EventBuilder.builder()
                    .organizer("Paradise Club")
                    .title("Paradise Club: Jazz Night Out")
                    .description("A night of class, jazz and relaxation. The perfect way to wind down from a hectic week.")
                    .media("https://static01.nyt.com/images/2019/06/27/fashion/26boite-paradise-1/merlin_156112236_98ab8e66-d7d4-41bf-969e-a968636f96a2-articleLarge.jpg?quality=75&auto=webp&disable=upscale")
                    .month(8)
                    .dayStart(19)
                    .hourStart(21)
                    .dayEnd(20)
                    .hourEnd(5)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event paradiseClubWelcomeToParadise() {
            return EventBuilder.builder()
                    .organizer("Paradise Club")
                    .title("Paradise Club: Welcome to Paradise")
                    .description("Sweet Sounds by QuestLove, guaranteeing a night of fun")
                    .media("https://www.ahotellife.com/wp-content/uploads/2019/04/BFA_27263_3377414.jpg")
                    .year(2023)
                    .month(4)
                    .dayStart(25)
                    .hourStart(23)
                    .dayEnd(26)
                    .hourEnd(5)
                    .price(30.00)
                    .build().toEvent();
        }

        public static Event musicaClubBirhtdayBash() {
            return EventBuilder.builder()
                    .organizer("Musica Club")
                    .title("Francesco Belcaro & Elijah Birthday Celebration")
                    .description("A birthday bash celebrating the birth of Francesco and Elija")
                    .media("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlm2tCWVpFKEO2-jYrXYPvmn02UVM9eoj8lA&usqp=CAU")
                    .month(7)
                    .dayStart(9)
                    .hourStart(22)
                    .dayEnd(10)
                    .hourEnd(5)
                    .price(40.00)
                    .build().toEvent();
        }

        public static Event theIridiumCocoMontoyaDAY1() {
            return EventBuilder.builder()
                    .organizer("The Iridium")
                    .title("Coco Montoya")
                    .description("A night at the Iridium listening to world famous Coco Montoya")
                    .media("https://static.wixstatic.com/media/349c85_82c24cabbba84ba68c710669e510a18b~mv2.jpg/v1/fill/w_493,h_309,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/Kaki%20King%20FACEBOOK%20HEADER%20V1.jpg")
                    .month(8)
                    .dayStart(16)
                    .hourStart(19)
                    .dayEnd(16)
                    .hourEnd(24)
                    .price(50.00)
                    .build().toEvent();
        }

        public static Event theIridiumCocoMontoyaDAY2() {
            return EventBuilder.builder()
                    .organizer("The Iridium")
                    .title("Coco Montoya")
                    .description("A night at the Iridium listening to world famous Coco Montoya")
                    .media("https://static.wixstatic.com/media/349c85_82c24cabbba84ba68c710669e510a18b~mv2.jpg/v1/fill/w_493,h_309,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/Kaki%20King%20FACEBOOK%20HEADER%20V1.jpg")
                    .month(8)
                    .dayStart(17)
                    .hourStart(19)
                    .dayEnd(17)
                    .hourEnd(24)
                    .price(60.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Berlin Events: 6
        // *************************************************************************************************************
        public static Event berghainFinestFriday() {
            return EventBuilder.builder()
                    .organizer("Berghain")
                    .title("Finest Friday")
                    .description("" +
                            "Unter dem Namen Barely Legal konnte sich die Britin Chloé Robinson in den vergangenen zehn Jahren als DJ mit Fokus auf Bassmusik, Grime und Garage etablieren und spielte regelmäßig im Londoner fabric und The Warehouse Project. " +
                            "Nachdem sie zunehmend auch House- und Technotracks in ihre Sets einfließen ließ, war im vergangenen Jahr ein Namenswechsel fällig. " +
                            "Seitdem spielt Robinson, die bereits mit 19 anfing aufzulegen, unter ihrem bürgerlichen Namen. Cryptofauna ist Resident-DJ im Hamburger Club PAL und legt auch zusammen mit ihrem Partner unter dem Namen Epikur auf. " +
                            "Streng gesetzte Genregrenzen sind bei ihr ebenfalls kein Thema – sie spielt von Acid über Psy Trance, House, Techno und ätherische Electronic alles, was gefällt und sich in dem Moment richtig auf dem Dancefloor anfühlt. " +
                            "Als Mitgründer und Resident der Bristoler Clubnacht Shapes hat Gallegos Partys an ungewöhnlichen Orten wie profanierte Kirchen veranstaltet. " +
                            "Nach einer Reihe an breakigen House-Releases auf Banoffee Pies hat er gerade seine eigene Plattform Room Service gestartet. " +
                            "rRoxymore spielte im Oktober auf unserer ersten Wiedereröffnungsklubnacht im Berghain und davor ein musiaklisch irres B2B mit Fiedel in der Dampfloge der Halle – ihr Set zum heutigen Finest Friday in der Panorama Bar dürfte musikalisch dazwischen liegen."
                    )
                    .media("https://cdn.berghain.berlin/media/images/berghain-12.17.2e16d0ba.fill-1000x350.jpg")
                    .month(7)
                    .dayStart(8)
                    .hourStart(22)
                    .dayEnd(9)
                    .hourEnd(5)
                    .price(18.00)
                    .build().toEvent();
        }

        public static Event berghainKlubnacht() {
            return EventBuilder.builder()
                    .organizer("Berghain")
                    .title("Klubnacht")
                    .description("" +
                            "Die in Tunesien aufgewachsene und im Alter von 26 Jahren nach Frankreich umgezogene Deena Abdelwahed verbindet klangliche Einflüsse ihrer alten Heimat mit zeitgenössischer elektronischen Musik. " +
                            "Ihre aktuelle EP heißt Dhakar, aus dem Arabischen übersetzt das Maskuline oder Männliche, und steht mit ihren komplexen rhythmischen Strukturen, der unnachgiebigen Energie und Referenzen an tunesische Volksmusik ganz in der Linie Abdelwaheds bisheriger Arbeiten. " +
                            "Heute spielt sie zur Klubnacht mit Mohajer, die neueste Mitglied der Fast-Forward-Productions-Crew, und Gael, einer in der russischen Kaukasus-Republik Dagestan aufgewachsenen Techno-DJ. " +
                            "Gael beweist in ihren Mixes ein Gespür für die richtige Balance aus düsteren Ambient Drones und kickenden Drums. " +
                            "Life Is Back hat die in Atlanta lebende Detroiterin Ash Lauryn bereits vor zwei Jahren auf ihrer EP Truth proklamiert, es sollte ja dann leider doch noch etwas dauern. " +
                            "Die Deephouse-DJ und Musikjournalistin führt den Blog Underground & Black und hostet die gleichnamige Radioshow auf NTS, auf der sie, wie in ihren DJ-Sets, überwiegend Musik von schwarzen US Amerikaner*innen spielt. " +
                            "Lauryn legt heute neben DJs wie der Londonerin FAUZIA und der Australierin Merve in der Panorama Bar auf."
                    )
                    .media("https://cdn.berghain.berlin/media/images/berghain-12.17.2e16d0ba.fill-1000x350.jpg")
                    .month(7)
                    .dayStart(9)
                    .hourStart(24)
                    .dayEnd(11)
                    .hourEnd(24)
                    .price(18.00)
                    .build().toEvent();
        }

        public static Event berghainShyGirl() {
            return EventBuilder.builder()
                    .organizer("Berghain")
                    .title("Shy Girl")
                    .description("“An amalgamation of genres born in the club, but not tied completely to it” is Shygirl's very apt description of her own sound. " +
                            "The South-East London born and raised musician, singer and DJ has been on a steady rise, for now culminating in this exclusive live show in Berghain. " +
                            "Proof of the above description is her genres-bending music itself, influenced by UK grime, pop music and industrial club sounds, but also the list of her collaborators and associates." +
                            "\n" +
                            "Shygirl has slowthai feature on the recent single “BDE” and Sega Bodega, Happa and Kid Karma co-produce her stellar EP Alias. " +
                            "Elsewhere, LSDXOXO and Basement Jaxx remix her songs, while she features on music by FKA twigs, Mura Masa, Arca and the late SOPHIE, among others. But this broad range of names, sounds, influences and aesthetics only reads eclectic written out – aesthetically and sonically, Shygirl is a singular voice, operating in a category of pop and emancipatory rap and she's made her own."
                    )
                    .media("https://cdn.berghain.berlin/media/images/Shygirl.width-1000.jpg")
                    .month(7)
                    .dayStart(13)
                    .hourStart(20)
                    .dayEnd(14)
                    .hourEnd(3)
                    .price(25.00)
                    .build().toEvent();
        }

        public static Event berghainEarthKlub() {
            return EventBuilder.builder()
                    .organizer("Berghain")
                    .title("Live From Earth Klub")
                    .description("Live From Earth Klub have a sure sense for exceptional acts with a certain crossover appeal. ALCATRAZ is the italo fun project of brothers Leo and Aaron Altaras. " +
                            "With their DJ sets they playfully draw references to their Italian roots and mix quite bluntly Italo Disco, electro and uptempo techno to an entertaining mescolanza: amore unlimited. " +
                            "Norwegian MRD takes a similar approach with his sound, clashing high-energy, breathless techno grooves with ingratiating pop hooks of Italo disco. " +
                            "Berlin-raised artist Ace Of Demons is co-founder of queer-focused collective HeartQore and plays edgy, diverse sets marked by a relentless rave energy. " +
                            "LFE resident DJ Gigola sums up her musical identity - probably part self-deprecating, part serious and concise - with “genre fluid”: breaks, trance, pop, techno, hiphop - the list of styles is even longer, the set sequence wild yet coherent, DJ Gigola as strange and thrilling as few others.")
                    .media("https://cdn.berghain.berlin/media/images/LFEK_Panorama_Bar_Landscape.width-1000.png")
                    .month(7)
                    .dayStart(15)
                    .hourStart(22)
                    .dayEnd(16)
                    .hourEnd(4)
                    .price(25.00)
                    .build().toEvent();
        }

        public static Event newVibesOlTingYAAM() {
            return EventBuilder.builder()
                    .organizer("YAAM")
                    .title("NEW VIBES OL’ TING")
                    .description("Watch out…. Nach über 2 Jahren Pause und monatelanger Planung, geht es endlich weiter. Vorab schon mal ein großer Dank an alle, die dieses mal im Background bei der Planung geholfen haben.\n" +
                            "NEW VIBZ OL’ TING geht in die 4. Veranstaltung. Dieses mal auch wieder im Sinne um Gelder für den guten Zweck zu Aquirieren.\n" +
                            "Bei meinem letzten Besuch in Gambia habe ich trauriger Weise feststellen müssen, dass sich das Krankenhaus in Gambia in einem sehr alten und unrenovierten Zustand befindet.\n" +
                            "Deshalb wird dieses mal der komplette Gewinn dem Krankenhaus in Gambia zu Gute kommen.\n" +
                            "Damit ihr natürlich alle auf eure Kosten kommt,\n" +
                            "wird wieder für ein hochkarätiges abwechslungsreiches Programm gesorgt. Mehr Dj’s und mehr Live-Artists. BOOM BANG")
                    .media("https://i0.wp.com/www.yaam.de/wp-content/uploads/2022/06/nvot-lang.jpg?w=1920&ssl=1")
                    .month(7)
                    .dayStart(2)
                    .hourStart(14)
                    .dayEnd(3)
                    .hourEnd(2)
                    .price(10.00)
                    .build().toEvent();
        }

        public static Event bantabaFestivalYAAM() {
            return EventBuilder.builder()
                    .organizer("YAAM")
                    .title("FETE DE LA MUSIQUE – BANTABA FESTIVAL")
                    .description("The Rhythm of life!")
                    .media("https://i0.wp.com/www.yaam.de/wp-content/uploads/2022/06/FETE_BANTABA_FB_BANNER.jpg?w=1920&ssl=1")
                    .month(6)
                    .dayStart(21)
                    .hourStart(14)
                    .dayEnd(21)
                    .hourEnd(22)
                    .price(10.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Copenhagen Events: 3
        // *************************************************************************************************************
        public static Event crazyKaraokeWednesdayCopenhagen() {
            return EventBuilder.builder()
                    .organizer("GAY Copenhagen nightclub")
                    .title("Crazy Koraoke Wednesday")
                    .description("Time to sing ur heart out. Patrick and Eric are ready with karaoke from 6 pm - midnight")
                    .media("https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F307449499%2F279973028887%2F1%2Foriginal.20220623-012333?w=1000&auto=format%2Ccompress&q=75&sharp=10&rect=24%2C0%2C530%2C265&s=2f9673a9a5106adde182a2588f337778")
                    .month(7)
                    .dayStart(13)
                    .hourStart(18)
                    .dayEnd(13)
                    .hourEnd(24)
                    .price(10.00)
                    .build().toEvent();
        }

        public static Event hiveGrandOpening() {
            return EventBuilder.builder()
                    .organizer("Hive")
                    .title("Grand Opening")
                    .description("Get ready for a fully renovated Hive")
                    .media("https://clubbable.blob.core.windows.net/medias/Sahel%20Hamdam_3802%20copy.jpg")
                    .month(11)
                    .dayStart(27)
                    .hourStart(22)
                    .dayEnd(28)
                    .hourEnd(5)
                    .price(20.00)
                    .build().toEvent();
        }
        public static Event hiveNoxClubSwamp() {
            return EventBuilder.builder()
                    .organizer("Hive")
                    .title("NOX CLUB SWAP")
                    .description("Get ready to be hit with the NOX")
                    .media("https://clubbable.blob.core.windows.net/medias/Sahel%20Hamdam_3486%20copy.jpg")
                    .month(12)
                    .dayStart(4)
                    .hourStart(21)
                    .dayEnd(25)
                    .hourEnd(5)
                    .price(15.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Shanghai Events: 4
        // *************************************************************************************************************
        public static Event M1NTSaturdayNightOut() {
            return EventBuilder.builder()
                    .organizer("M1NT")
                    .title("Saturday Night Out")
                    .description("Get ready to rumble because this saturday the party is on")
                    .media("https://scontent-frt3-1.xx.fbcdn.net/v/t1.6435-9/103096318_3148147638562539_5970739338061658744_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=cdbe9c&_nc_ohc=77c3euFbNfIAX9eCSH7&_nc_oc=AQmVo6b-VN5VUD5EwJs1nt8usccLf835iKexbYXsCOKkVBN1CCqOH2Az5JZxMvN4OyZUDvMMgdYmhq3DQLzdxrY6&_nc_ht=scontent-frt3-1.xx&oh=00_AT80W-InP2tfvc7COi2NOBMb-1sXQ1XVlURaa5VWliBMog&oe=62EEE8B6")
                    .month(9)
                    .dayStart(22)
                    .hourStart(22)
                    .dayEnd(23)
                    .hourEnd(5)
                    .price(30.00)
                    .build().toEvent();
        }

        public static Event M1NTWhiteAffair() {
            return EventBuilder.builder()
                    .organizer("M1NT")
                    .title("White affair")
                    .description("Season greetings, White affair is the perfect start to the summer")
                    .media("https://scontent-frx5-1.xx.fbcdn.net/v/t1.6435-9/101934821_3148143745229595_7007745905401528080_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=cdbe9c&_nc_ohc=oTM2MzJtgxAAX-OLuL6&_nc_ht=scontent-frx5-1.xx&oh=00_AT_vM9vTi0Z8hj_jWN73CnlR2sjJxFw8pqBlSOud03Tn_w&oe=62EE4D11")
                    .month(6)
                    .dayStart(6)
                    .hourStart(21)
                    .dayEnd(7)
                    .hourEnd(5)
                    .price(30.00)
                    .build().toEvent();
        }

        public static Event barRougeGirlsNightOut() {
            return EventBuilder.builder()
                    .organizer("Bar Rouge")
                    .title("Girls Night out")
                    .description("Time for a Girls night out")
                    .media("https://images.xceed.me/clubs/gallery/bar-rouge-shanghai-club-shanghai-xceed-10.jpg")
                    .month(8)
                    .dayStart(12)
                    .hourStart(21)
                    .dayEnd(13)
                    .hourEnd(2)
                    .price(12.00)
                    .build().toEvent();
        }

        public static Event barRougenNewYearEve() {
            return EventBuilder.builder()
                    .organizer("Bar Rouge")
                    .title("Chinese New Years Eve Party")
                    .description("Celebrate chinese new year with us at Bar Rouge, we guarantee a great time")
                    .media("https://static.247tickets.com/o_1cu1gp2br1tc31od71sgj1299rpui.jpg")
                    .year(2023)
                    .month(1)
                    .dayStart(22)
                    .hourStart(20)
                    .dayEnd(23)
                    .hourEnd(4)
                    .price(20.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Bangkok Events: 8
        // *************************************************************************************************************
        public static Event bullysHappyHour() {
            return EventBuilder.builder()
                    .organizer("Bully's")
                    .title("Happy hour")
                    .description("Come celebrate happy hour here at Bully's pub where every for every 2 drinks bought you get one for free")
                    .media("https://www.bullys-bangkok.com/wp-content/themes/bullys/img/ogimage.jpg")
                    .month(7)
                    .dayStart(22)
                    .hourStart(20)
                    .dayEnd(7)
                    .hourEnd(24)
                    .price(12.00)
                    .build().toEvent();
        }

        public static Event bullysFridayNightOut() {
            return EventBuilder.builder()
                    .organizer("Bully's")
                    .title("Friday Night out")
                    .description("Come celebrate the start of your weekend at Bully's!")
                    .media("https://www.bullys-bangkok.com/wp-content/themes/bullys/img/ogimage.jpg")
                    .month(8)
                    .dayStart(4)
                    .hourStart(20)
                    .dayEnd(5)
                    .hourEnd(2)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event bullysSuperbowlEvenings() {
            return EventBuilder.builder()
                    .organizer("Bully's")
                    .title("Superbowl at Bully's")
                    .description("Come watch the 2023 Superbowl at Bully's")
                    .media("https://media-cdn.tripadvisor.com/media/photo-s/0e/c6/60/9f/people-watching.jpg")
                    .year(2023)
                    .month(2)
                    .dayStart(12)
                    .hourStart(12)
                    .dayEnd(12)
                    .hourEnd(24)
                    .price(35.00)
                    .build().toEvent();
        }

        public static Event sugarClubsHipHopNight() {
            return EventBuilder.builder()
                    .organizer("Sugar Club")
                    .title("Hip Hop night ft DJ Kay")
                    .description("Time to let loose and have fun at Sugar!")
                    .media("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTr47nmUIVy1EM9oOG94IW7Gp0B6UvBVhubrg&usqp=CAU")
                    .month(11)
                    .dayStart(7)
                    .hourStart(22)
                    .dayEnd(8)
                    .hourEnd(5)
                    .price(15.00)
                    .build().toEvent();
        }

        public static Event sugarClubsValentinesDay() {
            return EventBuilder.builder()
                    .organizer("Sugar Club")
                    .title("Valentines Day party")
                    .description("Time to let loose and meet new people and give your love life a jump start")
                    .media("https://d3hwaim9vs2gfj.cloudfront.net/596-3161478610.jpg")
                    .year(2023)
                    .month(2)
                    .dayStart(14)
                    .hourStart(22)
                    .dayEnd(15)
                    .hourEnd(5)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event sugarClubsHalloween() {
            return EventBuilder.builder()
                    .organizer("Sugar Club")
                    .title("Halloween party")
                    .description("Time to get your costumes on and ready to give a scare!")
                    .media("https://clubfilter.directory/custom/domain_1/image_files/sitemgr_photo_376.jpg")
                    .month(10)
                    .dayStart(31)
                    .hourStart(18)
                    .dayEnd(31)
                    .hourEnd(24)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event sugarClubATrain() {
            return EventBuilder.builder()
                    .organizer("Sugar Club")
                    .title("A Train")
                    .description("Please welcome world famous A train to Bangkok Sugar Club!")
                    .media("https://i0.wp.com/clubbingthailand.com/wp-content/uploads/2018/10/11-08-18-Sugar-Club-Bangkok-A-Train.jpg?resize=1170%2C500&ssl=1")
                    .month(11)
                    .dayStart(8)
                    .hourStart(21)
                    .dayEnd(9)
                    .hourEnd(2)
                    .price(25.00)
                    .build().toEvent();
        }

        public static Event sugarClubKidInk() {
            return EventBuilder.builder()
                    .organizer("Sugar Club")
                    .title("Kid Ink")
                    .description("Please welcome world famous Kid Ink to Bangkok Sugar Club!")
                    .media("https://i0.wp.com/clubbingthailand.com/wp-content/uploads/2019/06/07-18-19-Sugar-Club-Bangkok-Kid-Ink.jpg?resize=1170%2C500&ssl=1")
                    .month(7)
                    .dayStart(18)
                    .hourStart(22)
                    .dayEnd(18)
                    .hourEnd(2)
                    .price(25.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // LA Events: 6
        // *************************************************************************************************************
        public static Event luttrelExchange() {
            return EventBuilder.builder()
                    .organizer("LA Exchange")
                    .title("Luttrel at Exchange")
                    .description("Please welcome world famous Luttrel to the famous club Luttrel")
                    .media("https://exchangela.com/wp-content/uploads/2022/05/07-15-22_EXLA_Luttrell_1920x1005_Horizontal.png")
                    .month(7)
                    .dayStart(15)
                    .hourStart(22)
                    .dayEnd(16)
                    .hourEnd(4)
                    .price(35.00)
                    .build().toEvent();
        }

        public static Event rudimentalDJExchange() {
            return EventBuilder.builder()
                    .organizer("LA Exchange")
                    .title("Rudimental DJ at Exchange")
                    .description("Please welcome world famous DJ Rudimental to the famous club Luttrel")
                    .media("https://exchangela.com/wp-content/uploads/2022/04/07-16-22_EXLA_Rudimental_1920x1080.png")
                    .month(7)
                    .dayStart(16)
                    .hourStart(22)
                    .dayEnd(17)
                    .hourEnd(4)
                    .price(35.00)
                    .build().toEvent();
        }

        public static Event killTheNoiseExchange() {
            return EventBuilder.builder()
                    .organizer("LA Exchange")
                    .title("Kill The Noise at Exchange")
                    .description("Get ready for the Kill the Noise Embrace album tour to the famous club Luttrel")
                    .media("https://exchangela.com/wp-content/uploads/2022/04/07-22-22_EXLA_Kill_The_Noise_Support_1920x1080.png")
                    .month(7)
                    .dayStart(22)
                    .hourStart(22)
                    .dayEnd(23)
                    .hourEnd(4)
                    .price(40.00)
                    .build().toEvent();
        }

        public static Event warfaceDeadlyGunsExchange() {
            return EventBuilder.builder()
                    .organizer("LA Exchange")
                    .title("Warface Deadly Guns at Exchange")
                    .description("Get ready for the best event of the year: Warface Deadly Guns Kill to the famous club Luttrel")
                    .media("https://exchangela.com/wp-content/uploads/2022/06/047-29-22_EXLA_BC_Warface__Deadly_Guns_1920x1005.png")
                    .month(7)
                    .dayStart(29)
                    .hourStart(22)
                    .dayEnd(30)
                    .hourEnd(4)
                    .price(30.00)
                    .build().toEvent();
        }

        public static Event fourthOfJulyClubCrawl() {
            return EventBuilder.builder()
                    .organizer("Club Crawl")
                    .title("Fourth of July at Club Crawl")
                    .description("Get ready for the fourth of July at Club Crawl")
                    .media("https://cdn.fourth-july.com/events5/banners/9a96ac18809543167bd2ff6f5bda4d7d88c4d3e9e9c3d03c78648cd20bc84874-rimg-w1200-h595-gmir.jpg?v=1653826119")
                    .month(7)
                    .dayStart(4)
                    .hourStart(22)
                    .dayEnd(5)
                    .hourEnd(2)
                    .price(20.00)
                    .build().toEvent();
        }

        public static Event GoldenNightClubCrawl() {
            return EventBuilder.builder()
                    .organizer("Club Crawl")
                    .title("Golden Night at Club Crawl")
                    .description("Get ready for Golden night at Club Crawl")
                    .media("https://media-cdn.tripadvisor.com/media/photo-s/18/dd/1f/f6/tourists-and-locals-to.jpg")
                    .month(8)
                    .dayStart(1)
                    .hourStart(21)
                    .dayEnd(2)
                    .hourEnd(3)
                    .price(25.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // South Korea Events: 3
        // *************************************************************************************************************
        public static Event rapNightSSoap() {
            return EventBuilder.builder()
                    .organizer("Soap Seoul")
                    .title("Rap Night at Soap Seoul")
                    .description("Get ready for Rap night at Soap Seoul")
                    .media("https://viberatecdn.blob.core.windows.net/entity/venue/soap-seoul-Fo3B3")
                    .month(8)
                    .dayStart(3)
                    .hourStart(22)
                    .dayEnd(4)
                    .hourEnd(4)
                    .price(15.00)
                    .build().toEvent();
        }

        public static Event redBullNightSSoap() {
            return EventBuilder.builder()
                    .organizer("Soap Seoul")
                    .title("Red Bull event at Soap Seoul")
                    .description("Soap Seoul is hosting a red bull event on the 30th of august")
                    .media("https://viberatecdn.blob.core.windows.net/entity/venue/soap-seoul-Fo3B3")
                    .month(8)
                    .dayStart(30)
                    .hourStart(21)
                    .dayEnd(31)
                    .hourEnd(4)
                    .price(25.00)
                    .build().toEvent();
        }

        public static Event ClubAuraGirlsNightOut() {
            return EventBuilder.builder()
                    .organizer("Hongdae Club Aura")
                    .title("Girls night out")
                    .description("Hongdae hosts a girl night out featuring Doja Cat")
                    .media("https://zula.sg/wp-content/uploads/2018/05/clubbing-in-seoul-cover-1200x900.jpg")
                    .month(12)
                    .dayStart(23)
                    .hourStart(21)
                    .dayEnd(24)
                    .hourEnd(3)
                    .price(22.00)
                    .build().toEvent();
        }

        // *************************************************************************************************************
        // Australia Events: 2
        // *************************************************************************************************************
        public static Event retroNightClubRetro() {
            return EventBuilder.builder()
                    .organizer("Club Retro")
                    .title("Retro night")
                    .description("Time for a retro night playing old tunes and classics. Time to get footloose")
                    .media("https://lh5.googleusercontent.com/p/AF1QipNsua7qPiTiJVwr2ErkyFGBTEsGzo4qD6vv__Wx=w480-h300-k-n")
                    .month(9)
                    .dayStart(18)
                    .hourStart(21)
                    .dayEnd(19)
                    .hourEnd(3)
                    .price(25.00)
                    .build().toEvent();
        }

        public static Event gameDayClubRetro() {
            return EventBuilder.builder()
                    .organizer("Club Retro")
                    .title("Game Day")
                    .description("Get ready for game day at Club retro")
                    .media("https://www.partystar.com.au/images/venue/159-3.jpg")
                    .month(10)
                    .dayStart(14)
                    .hourStart(18)
                    .dayEnd(15)
                    .hourEnd(24)
                    .price(20.00)
                    .build().toEvent();
        }


    public static DJ dj() {
        return new DJ();
    }
}
