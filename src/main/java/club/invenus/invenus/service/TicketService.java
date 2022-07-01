package club.invenus.invenus.service;

import club.invenus.invenus.domain.payment.Charge;
import club.invenus.invenus.domain.ticket.AvailableTicket;
import club.invenus.invenus.domain.ticket.Ticket;
import club.invenus.invenus.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public List<Ticket> createTickets(@NotNull List<AvailableTicket> availableTickets, @NotNull Charge charge) {
        List<Ticket> tickets = availableTickets.stream()
                .map(availableTicket -> Ticket.builder()
                        .availableTicket(availableTicket)
                        .charge(charge)
                        .build())
                .toList();
        return ticketRepository.saveAll(tickets);
    }
}
