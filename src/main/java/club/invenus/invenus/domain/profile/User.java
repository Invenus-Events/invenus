package club.invenus.invenus.domain.profile;

import club.invenus.invenus.domain.Address;
import club.invenus.invenus.domain.ticket.Ticket;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "invenus_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Embedded
    private Address address;

    @Column(name = "gender", nullable = false)
    private Address.Gender gender;


    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @Builder.Default
    private List<Ticket> tickets = new ArrayList<>();
}
