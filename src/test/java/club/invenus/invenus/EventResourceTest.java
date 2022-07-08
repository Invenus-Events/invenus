package club.invenus.invenus;

import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.event.EventInstance;
import club.invenus.invenus.domain.profile.DJ;
import club.invenus.invenus.repository.ClubRepository;
import club.invenus.invenus.repository.DJRepository;
import club.invenus.invenus.repository.EventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
@Disabled
public class EventResourceTest {

    @Autowired
    private DJRepository djRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        clubRepository.deleteAll();
        eventRepository.deleteAll();
        djRepository.deleteAll();

        DJ dj = djRepository.save(MockData.dj());

        // *************************************************************************************************************
        // Instantiate clubs:
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich clubs: 5
            // *********************************************************************************************************
            Club p1Club = clubRepository.save(MockData.p1Club());
            Club pacha = clubRepository.save(MockData.pacha());
            Club nulle = clubRepository.save(MockData.nulle());
            Club blitz = clubRepository.save(MockData.blitz());
            Club neuraum = clubRepository.save(MockData.neuraum());
            // *********************************************************************************************************
            // Luxembourg clubs: 2
            // *********************************************************************************************************
            Club melusinaClub = clubRepository.save(MockData.melusinaClub());
            Club rockhalClub = clubRepository.save(MockData.Rockhal());
            // *********************************************************************************************************
            // Zurich clubs: 2
            // *********************************************************************************************************
            Club samigoAmusement = clubRepository.save(MockData.samigoAmusement());
            Club clubBellevue = clubRepository.save(MockData.clubBellevue());
            // *********************************************************************************************************
            // Paris clubs: 2
            // *********************************************************************************************************
            Club rexClub = clubRepository.save(MockData.rexClub());
            Club petitbain = clubRepository.save(MockData.petitBain());
            // *********************************************************************************************************
            // New York clubs: 3
            // *********************************************************************************************************
            Club paradiseClub = clubRepository.save(MockData.paradiseClub());
            Club musicaClubNYC = clubRepository.save(MockData.musicaClubNYC());
            Club theIridium = clubRepository.save(MockData.theIridium());
            // *********************************************************************************************************
            // Berlin clubs: 2
            // *********************************************************************************************************
            Club Berghain = clubRepository.save(MockData.Berghain());
            Club YAAM = clubRepository.save(MockData.YAAM());
            // *********************************************************************************************************
            // Copenhagen clubs: 2
            // *********************************************************************************************************
            Club gayCopenhagenNightclub = clubRepository.save(MockData.gayCopenhagenNightclub());
            Club hiveCopenhagen = clubRepository.save(MockData.hiveCopenhagen());
            // *********************************************************************************************************
            // Shanghai clubs: 2
            // *********************************************************************************************************
            Club M1NT = clubRepository.save(MockData.M1NT());
            Club barRouge = clubRepository.save(MockData.barRouge());

        // *************************************************************************************************************
        // Instantiate Event data for clubs:
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich clubs: 5
            // *********************************************************************************************************
            Event p1Sommerfest = MockData.p1Sommerfest();
            p1Sommerfest.setClub(p1Club);
            List<EventInstance> p1SommerfestEventInstances = p1Sommerfest.getEventInstances();
            p1Sommerfest.setEventInstances(new ArrayList<>());

            Event p1PackMas = MockData.p1PackMas();
            p1PackMas.setClub(p1Club);
            List<EventInstance> p1PackMasEventInstances = p1PackMas.getEventInstances();
            p1PackMas.setEventInstances(new ArrayList<>());

            Event pachaFreitag = MockData.pachaFreitag();
            pachaFreitag.setClub(pacha);
            List<EventInstance> pachaFreitagInstances = pachaFreitag.getEventInstances();
            pachaFreitag.setEventInstances(new ArrayList<>());

            Event blitzAfterShow = MockData.blitzAftershow();
            blitzAfterShow.setClub(blitz);
            List<EventInstance> blitzAfterShowInstances = blitzAfterShow.getEventInstances();
            blitzAfterShow.setEventInstances(new ArrayList<>());

            Event neuraumClubSound = MockData.neuraumClubSound();
            neuraumClubSound.setClub(neuraum);
            List<EventInstance> neuraumClubSoundEventInstances = neuraumClubSound.getEventInstances();
            neuraumClubSound.setEventInstances(new ArrayList<>());

            Event nulleSommerfest = MockData.nulleSommerfest();
            nulleSommerfest.setClub(nulle);
            List<EventInstance> nulleSommerfestEventInstances = nulleSommerfest.getEventInstances();
            nulleSommerfest.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Luxembourg clubs: 2
            // *********************************************************************************************************
            Event tequilaNight = MockData.melusinaTequilaNight();
            tequilaNight.setClub(melusinaClub);
            List<EventInstance> tequilaNightEventInstances = tequilaNight.getEventInstances();
            tequilaNight.setEventInstances(new ArrayList<>());

            Event rockhalOpenAirBelval = MockData.rockhalOpenAirBelval();
            rockhalOpenAirBelval.setClub(rockhalClub);
            List<EventInstance> rockhalOpenAirBelvalInstance = rockhalOpenAirBelval.getEventInstances();
            rockhalOpenAirBelval.setEventInstances(new ArrayList<>());

        // *************************************************************************************************************
        // Save and set data for clubs:
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich clubs: 5
            // *********************************************************************************************************
            Event p1SommerfestNew = eventRepository.save(p1Sommerfest);
            p1SommerfestNew.setEventInstances(p1SommerfestEventInstances);

            Event p1PackMasNew = eventRepository.save(p1PackMas);
            p1PackMasNew.setEventInstances(p1PackMasEventInstances);


            Event pachaFreitagNew = eventRepository.save(pachaFreitag);
            pachaFreitagNew.setEventInstances(pachaFreitagInstances);


            Event blitzAfterShowNew = eventRepository.save(blitzAfterShow);
            blitzAfterShowNew.setEventInstances(blitzAfterShowInstances);


            Event neuraumClubSoundNew = eventRepository.save(neuraumClubSound);
            neuraumClubSoundNew.setEventInstances(neuraumClubSoundEventInstances);


            Event nulleSommerfestNew = eventRepository.save(nulleSommerfest);
            nulleSommerfestNew.setEventInstances(nulleSommerfestEventInstances);

            // *********************************************************************************************************
            // Luxembourg clubs: 2
            // *********************************************************************************************************
            Event tequilaNightNew = eventRepository.save(tequilaNight);
            tequilaNightNew.setEventInstances(tequilaNightEventInstances);

            Event rockhalOpenAirBelvalnew = eventRepository.save(rockhalOpenAirBelval);
            rockhalOpenAirBelvalnew.setEventInstances(rockhalOpenAirBelvalInstance);

        // *************************************************************************************************************
        // set Club instance information:
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich clubs: 5
            // *********************************************************************************************************
            p1SommerfestNew.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(p1SommerfestNew);
                eventInstance.setEventInstanceID(p1SommerfestNew.getEventId());
                eventInstance.setDj(dj);
            });

            p1PackMasNew.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(p1PackMasNew);
                eventInstance.setEventInstanceID(p1PackMasNew.getEventId());
                eventInstance.setDj(dj);
            });

            pachaFreitag.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(pachaFreitag);
                eventInstance.setEventInstanceID(pachaFreitag.getEventId());
                eventInstance.setDj(dj);
            });

            blitzAfterShow.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(blitzAfterShow);
                eventInstance.setEventInstanceID(blitzAfterShow.getEventId());
                eventInstance.setDj(dj);
            });

            neuraumClubSound.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(neuraumClubSound);
                eventInstance.setEventInstanceID(neuraumClubSound.getEventId());
                eventInstance.setDj(dj);
            });

            nulleSommerfest.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(nulleSommerfest);
                eventInstance.setEventInstanceID(nulleSommerfest.getEventId());
                eventInstance.setDj(dj);
            });
            // *********************************************************************************************************
            // Luxembourg clubs: 2
            // *********************************************************************************************************
            tequilaNightNew.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(tequilaNightNew);
                eventInstance.setEventInstanceID(tequilaNightNew.getEventId());
                eventInstance.setDj(dj);
            });

            rockhalOpenAirBelvalnew.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(rockhalOpenAirBelvalnew);
                eventInstance.setEventInstanceID(rockhalOpenAirBelvalnew.getEventId());
                eventInstance.setDj(dj);
            });


        // *************************************************************************************************************
        // Save Club instance to event Repository
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich clubs: 5
            // *********************************************************************************************************
            eventRepository.save(p1Sommerfest);
            eventRepository.save(p1PackMas);
            eventRepository.save(pachaFreitag);
            eventRepository.save(blitzAfterShow);
            eventRepository.save(neuraumClubSound);
            eventRepository.save(nulleSommerfest);

            // *********************************************************************************************************
            // Luxembourg clubs: 2
            // *********************************************************************************************************
            eventRepository.save(tequilaNight);
            eventRepository.save(rockhalOpenAirBelval);
    }

    @AfterEach
    public void cleanUp() {
       //clubRepository.deleteAll();
       //eventRepository.deleteAll();
       //djRepository.deleteAll();
    }

    // todo: move
    // todo: make string equality ignore ID & fix indentation
    @Test
    public void testGetClubs() throws Exception {
        mvc.perform(get("/clubs"))
                .andExpect(status().isOk())
                .andExpect(content().string("""
                        [
                          {
                            "id": "334dede9-63d7-4282-9c33-dba1acc87a90",
                            "name": "P1 Club",
                            "shortName": "P1",
                            "location": {
                              "address": "Prinzregentenstraße 1",
                              "city": "Munich",
                              "postCode": 80538,
                              "country": "Germany",
                              "latitude": 48.144466,
                              "longitude": 11.585315
                            },
                            "website": "https://p1-club.de",
                            "email": "contact@p1-club.de",
                            "phoneNumber": "089 2111140",
                            "description": "P1 Club Description",
                            "imageUrl": "https://assets.invenus.club/5c2faf66-439a-43e2-846a-db148c39df25",
                            "priceRange": "EXPENSIVE"
                          },
                          {
                            "id": "d808b268-415f-48e7-a57d-1481cda2dd26",
                            "name": "Melusina",
                            "shortName": "Melusina",
                            "location": {
                              "address": "145 Rue de la Tour Jacob",
                              "city": "Luxembourg City",
                              "postCode": 1831,
                              "country": "Luxembourg",
                              "latitude": 49.611233,
                              "longitude": 6.1367464
                            },
                            "website": "https://melusina.lu",
                            "email": "contact@melusina.lu",
                            "phoneNumber": "+352 26 00 89 75",
                            "description": "Melusina Club Description",
                            "imageUrl": "https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg",
                            "priceRange": "MEDIUM"
                          }
                        ]""".strip().lines().collect(Collectors.joining())));
    }

    @Test
    public void testGetEvents() throws Exception {
        mvc.perform(get("/events"))
                .andExpect(status().isOk())
                .andExpect(content().string("""
                        [
                          {
                            "id": "^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$",
                            "title": "Tequila Night 03.06.2022",
                            "timeFrame": {},
                            "price": 20.00,
                            "club": {
                              "id": "1ec035e6-8ad1-403f-9302-b2152cac3673",
                              "name": "Melusina",
                              "shortName": "Melusina",
                              "location": {
                                "address": "145 Rue de la Tour Jacob",
                                "city": "Luxembourg City",
                                "postCode": 1831,
                                "country": "Luxembourg",
                                "latitude": 49.611233,
                                "longitude": 6.1367464
                              },
                              "website": "https://melusina.lu",
                              "email": "contact@melusina.lu",
                              "phoneNumber": "+352 26 00 89 75",
                              "description": "Melusina Club Description",
                              "imageUrl": "https://melusina.luxtix.lu/wp-content/uploads/sites/6/2022/05/279490519_10159812678814491_7132232474335391011_n.jpeg",
                              "priceRange": "MEDIUM"
                            },
                            "organizer": "Melusina",
                            "imageUrl": "https://assets.invenus.club/341f762f-f217-4b1c-8abc-fc68fe3d2a9c",
                            "description": "\\uD83C\\uDF4BTEQUILA NIGHT \\uD83C\\uDF4B",
                            "location": {
                              "address": "145 Rue de la Tour Jacob",
                              "city": "Luxembourg City",
                              "postCode": 1831,
                              "country": "Luxembourg",
                              "latitude": 49.611233,
                              "longitude": 6.1367464
                            }
                          },
                          {
                            "id": "d72acb1e-8e04-4929-b0c9-caa672c9ad9a",
                            "title": "P1 SOMMERFEST 2022",
                            "timeFrame": {},
                            "price": 10.00,
                            "club": {
                              "id": "4b35465d-69fe-4e2d-b0e0-659bcc0c7743",
                              "name": "P1 Club",
                              "shortName": "P1",
                              "location": {
                                "address": "Prinzregentenstraße 1",
                                "city": "Munich",
                                "postCode": 80538,
                                "country": "Germany",
                                "latitude": 48.144466,
                                "longitude": 11.585315
                              },
                              "website": "https://p1-club.de",
                              "email": "contact@p1-club.de",
                              "phoneNumber": "089 2111140",
                              "description": "P1 Club Description",
                              "imageUrl": "https://assets.invenus.club/fb3c92cc-eb2b-4ab0-8aae-1f8061376873",
                              "priceRange": "EXPENSIVE"
                            },
                            "organizer": "P1 Club",
                            "imageUrl": "https://p1-club.de/wp-content/themes/p1-club-template/imageresize/resize.php?w=1500&src=https://p1-club.de/wp-content/uploads/2022/05/Website-Event.jpg",
                            "description": "Das P1 Sommerfest verschlägt uns in die Weiten des Ozeans: auf Luao Islands. Gemeinsam mit dir erkunden wir den „Aloha Spirit“ mit tropischen Melodien und vielen weiteren Überraschungen!\\n",
                            "location": {
                              "address": "Prinzregentenstraße 1",
                              "city": "Munich",
                              "postCode": 80538,
                              "country": "Germany",
                              "latitude": 48.144466,
                              "longitude": 11.585315
                            }
                          },
                          {
                            "id": "5c8df26b-537c-43c5-9f46-aaf1e633ffe5",
                            "title": "Pack Ma's! - Wiesn 2022",
                            "timeFrame": {},
                            "price": 15.00,
                            "club": {
                              "id": "4b35465d-69fe-4e2d-b0e0-659bcc0c7743",
                              "name": "P1 Club",
                              "shortName": "P1",
                              "location": {
                                "address": "Prinzregentenstraße 1",
                                "city": "Munich",
                                "postCode": 80538,
                                "country": "Germany",
                                "latitude": 48.144466,
                                "longitude": 11.585315
                              },
                              "website": "https://p1-club.de",
                              "email": "contact@p1-club.de",
                              "phoneNumber": "089 2111140",
                              "description": "P1 Club Description",
                              "imageUrl": "https://assets.invenus.club/fb3c92cc-eb2b-4ab0-8aae-1f8061376873",
                              "priceRange": "EXPENSIVE"
                            },
                            "organizer": "P1 Club",
                            "imageUrl": "https://assets.invenus.club/5c49fe55-0925-4a62-b63d-33ef1b72b9fb",
                            "description": "Zwei Jahre keine Wiesn, kein Gspusi, kein süffiges Festbier… Doch das Warten hat ein Ende und das größte Volksfest der Welt ist zurück!",
                            "location": {
                              "address": "Prinzregentenstraße 1",
                              "city": "Munich",
                              "postCode": 80538,
                              "country": "Germany",
                              "latitude": 48.144466,
                              "longitude": 11.585315
                            }
                          }
                        ]"""));
    }


}
