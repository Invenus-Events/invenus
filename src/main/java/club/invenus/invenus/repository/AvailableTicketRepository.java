package club.invenus.invenus.repository;

import club.invenus.invenus.domain.ticket.AvailableTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvailableTicketRepository extends CrudRepository<AvailableTicket, UUID> {
}
