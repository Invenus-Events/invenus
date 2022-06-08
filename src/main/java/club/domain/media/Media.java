package club.domain.media;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@ToString
public class Media {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private UUID mediaId;

    public String getURL() {
        return "assets.invenus.club/" + mediaId;
    }

}
