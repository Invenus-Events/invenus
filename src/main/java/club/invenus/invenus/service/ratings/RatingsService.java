package club.invenus.invenus.service.ratings;

import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@Service
public class RatingsService {

    private final List<RatingsProvider> ratingsProviders;
    private final ClubRepository clubRepository;

    @Autowired
    public RatingsService(List<RatingsProvider> ratingsProviders, ClubRepository clubRepository) {
        this.ratingsProviders = ratingsProviders;
        this.clubRepository = clubRepository;
    }

    @Transactional
    public void updateAllRankings() {
        for (Club club : clubRepository.findAll()) {
            updateRatings(club);
        }
    }

    @Transactional
    public void updateRatings(@NotNull Club club) {
        System.out.println("Updating ratings for club " + club.getName());

        for (RatingsProvider ratingsProvider : ratingsProviders) {
            try {
                ratingsProvider.mutateRatingCollection(club, club.getProfile().getRatingCollection());
            } catch (IOException e) {
                System.err.println("Failed to fetch rating from " + ratingsProvider.getClass().getName() + ": " + e.getMessage());
            }
        }

        clubRepository.save(club);
    }

    // TODO: DISABLED BECAUSE WE DONT WANNA SPEND MONEY ON IT
    //@Scheduled(cron = "0 0 0 * * *")
    //@Scheduled(fixedDelay = 100000000, initialDelay = 0)
    public void autoUpdater() {
        updateAllRankings();
    }
}
