package club.invenus.invenus.service.ratings;

import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.rating.RatingCollection;

import java.io.IOException;

public interface RatingsProvider {

    void mutateRatingCollection(Club club, RatingCollection ratingCollection) throws IOException;
}
