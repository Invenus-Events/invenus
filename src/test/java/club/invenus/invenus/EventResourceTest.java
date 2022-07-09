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
//import org.junit.jupiter.api.Disabled;
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
            // Munich events: 5
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
            // Luxembourg events: 2
            // *********************************************************************************************************
            Event tequilaNight = MockData.melusinaTequilaNight();
            tequilaNight.setClub(melusinaClub);
            List<EventInstance> tequilaNightEventInstances = tequilaNight.getEventInstances();
            tequilaNight.setEventInstances(new ArrayList<>());

            Event rockhalOpenAirBelval = MockData.rockhalOpenAirBelval();
            rockhalOpenAirBelval.setClub(rockhalClub);
            List<EventInstance> rockhalOpenAirBelvalInstance = rockhalOpenAirBelval.getEventInstances();
            rockhalOpenAirBelval.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Zurich events: 2
            // *********************************************************************************************************
            Event sundayZHDayParty = MockData.sundayZHDayParty();
            sundayZHDayParty.setClub(samigoAmusement);
            List<EventInstance> sundayZHDayPartyInstance = sundayZHDayParty.getEventInstances();
            sundayZHDayParty.setEventInstances(new ArrayList<>());

            Event secretIslandAfterParty = MockData.secretIslandAfterParty();
            secretIslandAfterParty.setClub(clubBellevue);
            List<EventInstance> secretIslandAfterPartyInstance = secretIslandAfterParty.getEventInstances();
            secretIslandAfterParty.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Paris events: 2
            // *********************************************************************************************************
            Event rexClubBakermatMat = MockData.rexClubBakermatMat();
            rexClubBakermatMat.setClub(rexClub);
            List<EventInstance> rexClubBakermatMatInstance = rexClubBakermatMat.getEventInstances();
            rexClubBakermatMat.setEventInstances(new ArrayList<>());

            Event festivalDesSouvenirsBrises = MockData.festivalDesSouvenirsBrises();
            festivalDesSouvenirsBrises.setClub(petitbain);
            List<EventInstance> festivalDesSouvenirsBrisesInstance = festivalDesSouvenirsBrises.getEventInstances();
            festivalDesSouvenirsBrises.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // New York City events: 6
            // *********************************************************************************************************
            Event paradiseClubHighFligher = MockData.paradiseClubHighFligher();
            paradiseClubHighFligher.setClub(paradiseClub);
            List<EventInstance> paradiseClubHighFligherInstance = paradiseClubHighFligher.getEventInstances();
            paradiseClubHighFligher.setEventInstances(new ArrayList<>());

            Event paradiseClubJazzNightOut = MockData.paradiseClubJazzNightOut();
            paradiseClubJazzNightOut.setClub(paradiseClub);
            List<EventInstance> paradiseClubJazzNightOutInstance = paradiseClubJazzNightOut.getEventInstances();
            paradiseClubJazzNightOut.setEventInstances(new ArrayList<>());

            Event paradiseClubWelcomeToParadise = MockData.paradiseClubWelcomeToParadise();
            paradiseClubWelcomeToParadise.setClub(paradiseClub);
            List<EventInstance> paradiseClubWelcomeToParadiseInstance = paradiseClubWelcomeToParadise.getEventInstances();
            paradiseClubWelcomeToParadise.setEventInstances(new ArrayList<>());

            Event musicaClubBirhtdayBash = MockData.musicaClubBirhtdayBash();
            musicaClubBirhtdayBash.setClub(musicaClubNYC);
            List<EventInstance> musicaClubBirhtdayBashInstance = musicaClubBirhtdayBash.getEventInstances();
            musicaClubBirhtdayBash.setEventInstances(new ArrayList<>());

            Event theIridiumCocoMontoyaDAY1 = MockData.theIridiumCocoMontoyaDAY1();
            theIridiumCocoMontoyaDAY1.setClub(theIridium);
            List<EventInstance> theIridiumCocoMontoyaDAY1Instance = theIridiumCocoMontoyaDAY1.getEventInstances();
            theIridiumCocoMontoyaDAY1.setEventInstances(new ArrayList<>());

            Event theIridiumCocoMontoyaDAY2 = MockData.theIridiumCocoMontoyaDAY2();
            theIridiumCocoMontoyaDAY2.setClub(theIridium);
            List<EventInstance> theIridiumCocoMontoyaDAY2Instance = theIridiumCocoMontoyaDAY2.getEventInstances();
            theIridiumCocoMontoyaDAY2.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Berlin events: 6
            // *********************************************************************************************************
            Event berghainFinestFriday = MockData.berghainFinestFriday();
            berghainFinestFriday.setClub(Berghain);
            List<EventInstance> berghainFinestFridayInstance = berghainFinestFriday.getEventInstances();
            berghainFinestFriday.setEventInstances(new ArrayList<>());

            Event berghainKlubnacht = MockData.berghainKlubnacht();
            berghainKlubnacht.setClub(Berghain);
            List<EventInstance> berghainKlubnachtInstance = berghainKlubnacht.getEventInstances();
            berghainKlubnacht.setEventInstances(new ArrayList<>());

            Event berghainShyGirl = MockData.berghainShyGirl();
            berghainShyGirl.setClub(Berghain);
            List<EventInstance> berghainShyGirlInstance = berghainShyGirl.getEventInstances();
            berghainShyGirl.setEventInstances(new ArrayList<>());

            Event berghainEarthKlub = MockData.berghainEarthKlub();
            berghainEarthKlub.setClub(Berghain);
            List<EventInstance> berghainEarthKlubInstance = berghainEarthKlub.getEventInstances();
            berghainEarthKlub.setEventInstances(new ArrayList<>());

            Event newVibesOlTingYAAM = MockData.newVibesOlTingYAAM();
            newVibesOlTingYAAM.setClub(YAAM);
            List<EventInstance> newVibesOlTingYAAMInstance = berghainEarthKlub.getEventInstances();
            newVibesOlTingYAAM.setEventInstances(new ArrayList<>());

            Event bantabaFestivalYAAM = MockData.bantabaFestivalYAAM();
            bantabaFestivalYAAM.setClub(YAAM);
            List<EventInstance> bantabaFestivalYAAMiInstance = bantabaFestivalYAAM.getEventInstances();
            bantabaFestivalYAAM.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Copenhagen events: 3
            // *********************************************************************************************************
            Event crazyKaraokeWednesdayCopenhagen = MockData.crazyKaraokeWednesdayCopenhagen();
            crazyKaraokeWednesdayCopenhagen.setClub(gayCopenhagenNightclub);
            List<EventInstance> crazyKaraokeWednesdayCopenhagenInstance = crazyKaraokeWednesdayCopenhagen.getEventInstances();
            crazyKaraokeWednesdayCopenhagen.setEventInstances(new ArrayList<>());

            Event hiveGrandOpening = MockData.hiveGrandOpening();
            hiveGrandOpening.setClub(hiveCopenhagen);
            List<EventInstance> hiveGrandOpeningInstance = hiveGrandOpening.getEventInstances();
            hiveGrandOpening.setEventInstances(new ArrayList<>());

            Event hiveNoxClubSwamp = MockData.hiveNoxClubSwamp();
            hiveNoxClubSwamp.setClub(hiveCopenhagen);
            List<EventInstance> hiveNoxClubSwampInstance = hiveNoxClubSwamp.getEventInstances();
            hiveNoxClubSwamp.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Shanghai events: 4
            // *********************************************************************************************************
            Event M1NTSaturdayNightOut = MockData.M1NTSaturdayNightOut();
            M1NTSaturdayNightOut.setClub(M1NT);
            List<EventInstance> M1NTSaturdayNightOutInstance = M1NTSaturdayNightOut.getEventInstances();
            M1NTSaturdayNightOut.setEventInstances(new ArrayList<>());

            Event M1NTWhiteAffair = MockData.M1NTWhiteAffair();
            M1NTWhiteAffair.setClub(M1NT);
            List<EventInstance> M1NTWhiteAffairInstance = M1NTWhiteAffair.getEventInstances();
            M1NTWhiteAffair.setEventInstances(new ArrayList<>());

            Event barRougeGirlsNightOut = MockData.barRougeGirlsNightOut();
            barRougeGirlsNightOut.setClub(barRouge);
            List<EventInstance> barRougeGirlsNightOutInstance = barRougeGirlsNightOut.getEventInstances();
            barRougeGirlsNightOut.setEventInstances(new ArrayList<>());

            Event barRougenNewYearEve = MockData.barRougenNewYearEve();
            barRougenNewYearEve.setClub(barRouge);
            List<EventInstance> barRougenNewYearEveInstance = barRougenNewYearEve.getEventInstances();
            barRougenNewYearEve.setEventInstances(new ArrayList<>());

            // *********************************************************************************************************
            // Bangkok events: 8
            // *********************************************************************************************************


        // *************************************************************************************************************
        // Save and set data for club events:
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich events: 5
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
            // Luxembourg events: 2
            // *********************************************************************************************************
            Event tequilaNightNew = eventRepository.save(tequilaNight);
            tequilaNightNew.setEventInstances(tequilaNightEventInstances);

            Event rockhalOpenAirBelvalnew = eventRepository.save(rockhalOpenAirBelval);
            rockhalOpenAirBelvalnew.setEventInstances(rockhalOpenAirBelvalInstance);

            // *********************************************************************************************************
            // Zurich events: 2
            // *********************************************************************************************************
            Event sundayZHDayPartyNew = eventRepository.save(sundayZHDayParty);
            sundayZHDayPartyNew.setEventInstances(sundayZHDayPartyInstance);

            Event secretIslandAfterPartyNew = eventRepository.save(secretIslandAfterParty);
            secretIslandAfterPartyNew.setEventInstances(secretIslandAfterPartyInstance);

            // *********************************************************************************************************
            // Paris events: 2
            // *********************************************************************************************************
            Event rexClubBakermatMatNew = eventRepository.save(rexClubBakermatMat);
            rexClubBakermatMatNew.setEventInstances(rexClubBakermatMatInstance);

            Event festivalDesSouvenirsBrisesNew = eventRepository.save(festivalDesSouvenirsBrises);
            festivalDesSouvenirsBrisesNew.setEventInstances(festivalDesSouvenirsBrisesInstance);

            // *********************************************************************************************************
            // New York City events: 6
            // *********************************************************************************************************
            Event paradiseClubHighFligherNew = eventRepository.save(paradiseClubHighFligher);
            paradiseClubHighFligherNew.setEventInstances(paradiseClubHighFligherInstance);

            Event paradiseClubJazzNightOutNew = eventRepository.save(paradiseClubJazzNightOut);
            paradiseClubJazzNightOutNew.setEventInstances(paradiseClubJazzNightOutInstance);

            Event paradiseClubWelcomeToParadiseNew = eventRepository.save(paradiseClubWelcomeToParadise);
            paradiseClubWelcomeToParadiseNew.setEventInstances(paradiseClubWelcomeToParadiseInstance);

            Event musicaClubBirhtdayBashNew = eventRepository.save(musicaClubBirhtdayBash);
            musicaClubBirhtdayBashNew.setEventInstances(musicaClubBirhtdayBashInstance);

            Event theIridiumCocoMontoyaDAY1New = eventRepository.save(theIridiumCocoMontoyaDAY1);
            theIridiumCocoMontoyaDAY1New.setEventInstances(theIridiumCocoMontoyaDAY1Instance);

            Event theIridiumCocoMontoyaDAY2New = eventRepository.save(theIridiumCocoMontoyaDAY2);
            theIridiumCocoMontoyaDAY2New.setEventInstances(theIridiumCocoMontoyaDAY2Instance);

            // *********************************************************************************************************
            // Berlin events: 6
            // *********************************************************************************************************
            Event berghainFinestFridayNew = eventRepository.save(berghainFinestFriday);
            berghainFinestFridayNew.setEventInstances(berghainFinestFridayInstance);

            Event berghainKlubnachtNew = eventRepository.save(berghainKlubnacht);
            berghainKlubnachtNew.setEventInstances(berghainKlubnachtInstance);

            Event berghainShyGirlNew = eventRepository.save(berghainShyGirl);
            berghainShyGirlNew.setEventInstances(berghainShyGirlInstance);

            Event berghainEarthKlubNew = eventRepository.save(berghainEarthKlub);
            berghainEarthKlubNew.setEventInstances(berghainEarthKlubInstance);

            Event newVibesOlTingYAAMNew = eventRepository.save(newVibesOlTingYAAM);
            newVibesOlTingYAAMNew.setEventInstances(newVibesOlTingYAAMInstance);

            Event bantabaFestivalYAAMNew = eventRepository.save(bantabaFestivalYAAM);
            bantabaFestivalYAAMNew.setEventInstances(bantabaFestivalYAAMiInstance);

            // *********************************************************************************************************
            // Copenhagen events: 3
            // *********************************************************************************************************
            Event crazyKaraokeWednesdayCopenhagenNew = eventRepository.save(crazyKaraokeWednesdayCopenhagen);
            crazyKaraokeWednesdayCopenhagenNew.setEventInstances(crazyKaraokeWednesdayCopenhagenInstance);

            Event hiveGrandOpeningNew = eventRepository.save(hiveGrandOpening);
            hiveGrandOpeningNew.setEventInstances(hiveGrandOpeningInstance);

            Event hiveNoxClubSwampNew = eventRepository.save(hiveNoxClubSwamp);
            hiveNoxClubSwampNew.setEventInstances(hiveNoxClubSwampInstance);

            // *********************************************************************************************************
            // Shanghai events: 4
            // *********************************************************************************************************
            Event M1NTSaturdayNightOutNew = eventRepository.save(M1NTSaturdayNightOut);
            M1NTSaturdayNightOutNew.setEventInstances(M1NTSaturdayNightOutInstance);

            Event M1NTWhiteAffairNew = eventRepository.save(M1NTWhiteAffair);
            M1NTWhiteAffairNew.setEventInstances(M1NTWhiteAffairInstance);

            Event barRougeGirlsNightOutNew = eventRepository.save(barRougeGirlsNightOut);
            barRougeGirlsNightOut.setEventInstances(barRougeGirlsNightOutInstance);

            Event barRougenNewYearEveNew = eventRepository.save(barRougenNewYearEve);
            barRougenNewYearEveNew.setEventInstances(barRougenNewYearEveInstance);


        // *************************************************************************************************************
        // set Club instance information:
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich events: 5
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
            // Luxembourg events: 2
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

            // *********************************************************************************************************
            // Zurich events: 2
            // *********************************************************************************************************
            sundayZHDayParty.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(sundayZHDayPartyNew);
                eventInstance.setEventInstanceID(sundayZHDayPartyNew.getEventId());
                eventInstance.setDj(dj);
            });

            secretIslandAfterParty.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(secretIslandAfterPartyNew);
                eventInstance.setEventInstanceID(secretIslandAfterPartyNew.getEventId());
                eventInstance.setDj(dj);
            });

            // *********************************************************************************************************
            // Paris events: 2
            // *********************************************************************************************************
            rexClubBakermatMat.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(rexClubBakermatMatNew);
                eventInstance.setEventInstanceID(rexClubBakermatMatNew.getEventId());
                eventInstance.setDj(dj);
            });

            festivalDesSouvenirsBrises.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(festivalDesSouvenirsBrisesNew);
                eventInstance.setEventInstanceID(festivalDesSouvenirsBrisesNew.getEventId());
                eventInstance.setDj(dj);
            });

            // *********************************************************************************************************
            // New York City events: 6
            // *********************************************************************************************************
            paradiseClubHighFligher.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(paradiseClubHighFligherNew);
                eventInstance.setEventInstanceID(paradiseClubHighFligherNew.getEventId());
                eventInstance.setDj(dj);
            });

            paradiseClubJazzNightOut.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(paradiseClubJazzNightOutNew);
                eventInstance.setEventInstanceID(paradiseClubJazzNightOutNew.getEventId());
                eventInstance.setDj(dj);
            });

            paradiseClubWelcomeToParadise.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(paradiseClubWelcomeToParadiseNew);
                eventInstance.setEventInstanceID(paradiseClubWelcomeToParadiseNew.getEventId());
                eventInstance.setDj(dj);
            });

            musicaClubBirhtdayBash.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(musicaClubBirhtdayBashNew);
                eventInstance.setEventInstanceID(musicaClubBirhtdayBashNew.getEventId());
                eventInstance.setDj(dj);
            });

            theIridiumCocoMontoyaDAY1.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(theIridiumCocoMontoyaDAY1New);
                eventInstance.setEventInstanceID(theIridiumCocoMontoyaDAY1New.getEventId());
                eventInstance.setDj(dj);
            });

            theIridiumCocoMontoyaDAY2.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(theIridiumCocoMontoyaDAY2New);
                eventInstance.setEventInstanceID(theIridiumCocoMontoyaDAY2New.getEventId());
                eventInstance.setDj(dj);
            });

            // *********************************************************************************************************
            // Berlin events: 6
            // *********************************************************************************************************
            berghainFinestFriday.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(berghainFinestFridayNew);
                eventInstance.setEventInstanceID(berghainFinestFridayNew.getEventId());
                eventInstance.setDj(dj);
            });

            berghainKlubnacht.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(berghainKlubnachtNew);
                eventInstance.setEventInstanceID(berghainKlubnachtNew.getEventId());
                eventInstance.setDj(dj);
            });

            berghainShyGirl.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(berghainShyGirlNew);
                eventInstance.setEventInstanceID(berghainShyGirlNew.getEventId());
                eventInstance.setDj(dj);
            });

            berghainEarthKlub.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(berghainEarthKlubNew);
                eventInstance.setEventInstanceID(berghainEarthKlubNew.getEventId());
                eventInstance.setDj(dj);
            });

            newVibesOlTingYAAM.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(newVibesOlTingYAAMNew);
                eventInstance.setEventInstanceID(newVibesOlTingYAAMNew.getEventId());
                eventInstance.setDj(dj);
            });

            bantabaFestivalYAAM.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(bantabaFestivalYAAMNew);
                eventInstance.setEventInstanceID(bantabaFestivalYAAMNew.getEventId());
                eventInstance.setDj(dj);
            });

            // *********************************************************************************************************
            // Copenhagen events: 3
            // *********************************************************************************************************
            crazyKaraokeWednesdayCopenhagen.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(crazyKaraokeWednesdayCopenhagenNew);
                eventInstance.setEventInstanceID(crazyKaraokeWednesdayCopenhagenNew.getEventId());
                eventInstance.setDj(dj);
            });

            hiveGrandOpening.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(hiveGrandOpeningNew);
                eventInstance.setEventInstanceID(hiveGrandOpeningNew.getEventId());
                eventInstance.setDj(dj);
            });

            hiveNoxClubSwamp.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(hiveNoxClubSwampNew);
                eventInstance.setEventInstanceID(hiveNoxClubSwampNew.getEventId());
                eventInstance.setDj(dj);
            });

            // *********************************************************************************************************
            // Shanghai events: 4
            // *********************************************************************************************************
            M1NTSaturdayNightOut.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(M1NTSaturdayNightOutNew);
                eventInstance.setEventInstanceID(M1NTSaturdayNightOutNew.getEventId());
                eventInstance.setDj(dj);
            });

            M1NTWhiteAffair.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(M1NTWhiteAffairNew);
                eventInstance.setEventInstanceID(M1NTWhiteAffairNew.getEventId());
                eventInstance.setDj(dj);
            });

            barRougeGirlsNightOut.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(barRougeGirlsNightOutNew);
                eventInstance.setEventInstanceID(barRougeGirlsNightOutNew.getEventId());
                eventInstance.setDj(dj);
            });

            barRougenNewYearEve.getEventInstances().forEach(eventInstance -> {
                eventInstance.setEvent(barRougenNewYearEveNew);
                eventInstance.setEventInstanceID(barRougeGirlsNightOutNew.getEventId());
                eventInstance.setDj(dj);
            });

        // *************************************************************************************************************
        // Save Club instance to event Repository
        // *************************************************************************************************************

            // *********************************************************************************************************
            // Munich events: 5
            // *********************************************************************************************************
            eventRepository.save(p1Sommerfest);
            eventRepository.save(p1PackMas);
            eventRepository.save(pachaFreitag);
            eventRepository.save(blitzAfterShow);
            eventRepository.save(neuraumClubSound);
            eventRepository.save(nulleSommerfest);

            // *********************************************************************************************************
            // Luxembourg events: 2
            // *********************************************************************************************************
            eventRepository.save(tequilaNight);
            eventRepository.save(rockhalOpenAirBelval);

            // *********************************************************************************************************
            // Zurich events: 2
            // *********************************************************************************************************
            eventRepository.save(sundayZHDayParty);
            eventRepository.save(secretIslandAfterParty);

            // *********************************************************************************************************
            // Paris events: 2
            // *********************************************************************************************************
            eventRepository.save(rexClubBakermatMat);
            eventRepository.save(festivalDesSouvenirsBrises);

            // *********************************************************************************************************
            // New York events: 6
            // *********************************************************************************************************
            eventRepository.save(paradiseClubHighFligher);
            eventRepository.save(paradiseClubJazzNightOut);
            eventRepository.save(paradiseClubWelcomeToParadise);
            eventRepository.save(musicaClubBirhtdayBash);
            eventRepository.save(theIridiumCocoMontoyaDAY1);
            eventRepository.save(theIridiumCocoMontoyaDAY2);

            // *********************************************************************************************************
            // Berlin events: 6
            // *********************************************************************************************************
            eventRepository.save(berghainFinestFriday);
            eventRepository.save(berghainKlubnacht);
            eventRepository.save(berghainShyGirl);
            eventRepository.save(berghainEarthKlub);
            eventRepository.save(newVibesOlTingYAAM);
            eventRepository.save(bantabaFestivalYAAM);

            // *********************************************************************************************************
            // Copenhagen events: 3
            // *********************************************************************************************************
            eventRepository.save(crazyKaraokeWednesdayCopenhagen);
            eventRepository.save(hiveGrandOpening);
            eventRepository.save(hiveNoxClubSwamp);

            // *********************************************************************************************************
            // Shanghai events: 4
            // *********************************************************************************************************
            eventRepository.save(M1NTSaturdayNightOut);
            eventRepository.save(M1NTWhiteAffair);
            eventRepository.save(barRougeGirlsNightOut);
            eventRepository.save(barRougenNewYearEve);
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
