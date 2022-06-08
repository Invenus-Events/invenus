package club.domain.event;

import club.domain.TimeFrame;
import club.domain.profile.DJ;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "event_instance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@ToString
public class EventInstance {

    @Id
    @Column(name = "event_instance_id")
    private UUID eventInstanceID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false, updatable = false)
    private Event event;

    @Embedded
    private TimeFrame timeFrame;

    @ManyToOne
    @JoinColumn(name = "dj_id")
    private DJ dj;
}
