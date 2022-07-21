package club.invenus.invenus.service.dto;

import club.invenus.invenus.domain.rating.RatingCollection;
import lombok.Data;

@Data
public class RatingCollectionDTO {

    private RatingsDTO googleRatings;

    public RatingCollectionDTO(RatingCollection ratingCollection) {
        this.googleRatings = new RatingsDTO(ratingCollection.getGoogleRatings());
    }

}
