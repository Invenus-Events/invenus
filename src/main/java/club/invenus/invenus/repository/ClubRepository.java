package club.invenus.invenus.repository;

import club.domain.club.Club;
import club.domain.event.EventInstance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface ClubRepository extends ExtendedRepository<Club, UUID> {
}

