package club.invenus.invenus.repository;

import club.invenus.invenus.domain.club.Club;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClubRepository extends ExtendedRepository<Club, UUID> {
}
