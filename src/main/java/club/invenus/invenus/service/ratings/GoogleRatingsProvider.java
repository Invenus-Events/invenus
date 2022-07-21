package club.invenus.invenus.service.ratings;

import club.invenus.invenus.domain.club.Club;
import club.invenus.invenus.domain.rating.Rating;
import club.invenus.invenus.domain.rating.RatingCollection;
import club.invenus.invenus.domain.rating.Ratings;
import com.google.maps.GeoApiContext;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GoogleRatingsProvider implements RatingsProvider {

    private final GeoApiContext geoApiContext;

    @Autowired
    public GoogleRatingsProvider(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    @Override
    public void mutateRatingCollection(Club club, RatingCollection ratingCollection) throws IOException {
        LatLng latlng = new LatLng(club.getLocation().getLatitude(), club.getLocation().getLongitude());
        TextSearchRequest request = PlacesApi.textSearchQuery(geoApiContext, "club " + club.getName(), latlng).radius(100);
        PlacesSearchResponse response = request.awaitIgnoreError();

        if (response.results.length == 0) {
            return;
        }

        PlacesSearchResult result = response.results[0];
        String placeId = result.placeId;

        PlaceDetails placeDetails = PlacesApi.placeDetails(geoApiContext, placeId).awaitIgnoreError();
        Ratings googleRatings = ratingCollection.getGoogleRatings();
        if (googleRatings == null) {
            googleRatings = new Ratings();
            ratingCollection.setGoogleRatings(googleRatings);
        }

        List<Rating> ratings = ratingCollection.getGoogleRatings().getRatings();
        ratings.clear();
        for (PlaceDetails.Review review : placeDetails.reviews) {
            Rating rating = Rating.builder()
                    .rater(review.authorName)
                    .rating(review.rating / 2.0)
                    .comment(review.text)
                    .build();
            ratings.add(rating);
        }

        ratingCollection.getGoogleRatings().setRating(placeDetails.rating);
    }


}
