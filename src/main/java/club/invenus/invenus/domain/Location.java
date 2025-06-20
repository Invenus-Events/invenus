package club.invenus.invenus.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Embedded
    @JsonUnwrapped
    private Address address;

    @NotNull
    @Column(name = "lat", columnDefinition = "float4")
    private float latitude;

    @NotNull
    @Column(name = "lon", columnDefinition = "float4")
    private float longitude;

}
