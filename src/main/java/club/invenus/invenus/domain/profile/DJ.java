package club.invenus.invenus.domain.profile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "dj_profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Setter
@Getter
@ToString
public class DJ {

    @Id
    @Column(name = "dj_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID djId;



}
