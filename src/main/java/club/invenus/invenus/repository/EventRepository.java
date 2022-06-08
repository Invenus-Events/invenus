package club.invenus.invenus.repository;

import club.domain.event.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface EventRepository extends ExtendedRepository<Event, UUID> {
}

