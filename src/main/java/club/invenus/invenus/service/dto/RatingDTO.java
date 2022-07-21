package club.invenus.invenus.service.dto;

import club.invenus.invenus.domain.rating.Rating;
import lombok.Data;

@Data
public class RatingDTO {

    private final String author;
    private final String message;
    private final double rating;

    public RatingDTO(Rating rating) {
        this.author = rating.getRater();
        this.message = rating.getComment();
        this.rating = rating.getRating();
    }

}
