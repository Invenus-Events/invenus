package club.invenus.invenus.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TimeFrame {

    @Column(name = "time_from", columnDefinition = "TIMESTAMP")
    private LocalDateTime from;

    @Column(name = "time_to", columnDefinition = "TIMESTAMP")
    private LocalDateTime to;


}
