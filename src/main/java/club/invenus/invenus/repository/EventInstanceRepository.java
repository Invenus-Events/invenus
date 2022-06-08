package club.invenus.invenus.repository;

import club.domain.event.EventInstance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface EventInstanceRepository extends ExtendedRepository<EventInstance, UUID> {

}

