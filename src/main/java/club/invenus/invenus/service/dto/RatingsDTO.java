package club.invenus.invenus.service.dto;

import club.invenus.invenus.domain.rating.Rating;
import club.invenus.invenus.domain.rating.Ratings;
import lombok.Data;

import java.util.List;

@Data
public class RatingsDTO {

    private final double rating;
    private final List<RatingDTO> ratings;

    public RatingsDTO(Ratings ratings) {
        this.rating = ratings.getRating();
        this.ratings = ratings.getRatings().stream()
                .map(RatingDTO::new)
                .toList();
    }

}
