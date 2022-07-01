package club.invenus.invenus.repository;

import club.invenus.invenus.domain.payment.Charge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChargeRepository extends ExtendedRepository<Charge, UUID> {
}
