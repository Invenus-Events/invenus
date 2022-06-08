package club.invenus.invenus.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @NotNull
    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    private String address;

    @NotNull
    @Column(name = "city", columnDefinition = "VARCHAR(255)")
    private String city;

    @NotNull
    @Column(name = "post_code", columnDefinition = "VARCHAR(255)")
    private int postCode;

    @NotNull
    @Column(name = "country", columnDefinition = "VARCHAR(255)")
    private String country;

    @NotNull
    @Column(name = "lat", columnDefinition = "float4")
    private float latitude;

    @NotNull
    @Column(name = "lon", columnDefinition = "float4")
    private float longitude;

}
