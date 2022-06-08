package club.invenus.invenus.domain.media;

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

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "media_id")
    private UUID mediaId;

    // TODO: TEMPORARY
    // TODO: MEDIA INTEGRATION DOESNT WORK YET
    @Column(name = "media_overwrite")
    private String overwrite;

    // TODO: TEMPORARY
    public Media() {
        this.mediaId = UUID.randomUUID();
    }

    public String getURL() {
        if (overwrite != null) {
            return overwrite;
        } else {
            return "assets.invenus.club/" + mediaId;
        }
    }

}
