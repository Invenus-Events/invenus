package club.invenus.invenus.repository;

import club.invenus.invenus.domain.event.EventInstance;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventInstanceRepository extends ExtendedRepository<EventInstance, UUID> {

}

