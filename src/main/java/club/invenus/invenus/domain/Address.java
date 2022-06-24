package club.invenus.invenus.domain;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Embeddable
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

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

}
