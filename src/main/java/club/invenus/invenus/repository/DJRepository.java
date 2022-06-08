package club.invenus.invenus.repository;

import club.invenus.invenus.domain.profile.DJ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DJRepository extends CrudRepository<DJ, UUID> {
}
