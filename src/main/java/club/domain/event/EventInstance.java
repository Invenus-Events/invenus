package club.domain.event;

import club.domain.TimeFrame;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Setter
@Embeddable
public class EventInstance {

    @Embedded
    private TimeFrame timeFrame;

    @Embedded
    private DJ dj;
}
