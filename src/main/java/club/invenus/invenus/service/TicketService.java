package club.invenus.invenus.service;

import club.invenus.invenus.domain.Location;
import club.invenus.invenus.domain.event.Event;
import club.invenus.invenus.domain.payment.Charge;
import club.invenus.invenus.domain.ticket.AvailableClubTicket;
import club.invenus.invenus.domain.ticket.AvailableEventTicket;
import club.invenus.invenus.domain.ticket.AvailableTicket;
import club.invenus.invenus.domain.ticket.Ticket;
import club.invenus.invenus.repository.TicketRepository;
import club.invenus.invenus.service.dto.TicketJwtDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Value("${invenus.web-url}")
    private String webUrl;

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
                        .jwt(createJwt(availableTicket))
                        .build())
                .toList();
        return ticketRepository.saveAll(tickets);
    }

    private String createJwt(@NotNull AvailableTicket ticket) {
        TicketJwtDTO dto;
        if (ticket instanceof AvailableEventTicket t) {
            Event event = t.getEventInstance().getEvent();
            Location location = event.getClub().getLocation();
            dto = TicketJwtDTO.builder()
                    .title(event.getTitle())
                    .club(event.getClub().getName())
                    .from(t.getEventInstance().getTimeFrame().getFrom())
                    .address(location.getAddress().getAddress())
                    .postCode(location.getAddress().getPostCode())
                    .city(location.getAddress().getCity())
                    .build();
        } else if (ticket instanceof AvailableClubTicket t){
            Location location = t.getClub().getLocation();
            dto = TicketJwtDTO.builder()
                    .title(t.getClub().getName())
                    .club(t.getClub().getName())
                    .from(t.getDate().atStartOfDay())
                    .address(location.getAddress().getAddress())
                    .postCode(location.getAddress().getPostCode())
                    .city(location.getAddress().getCity())
                    .build();
        } else {
            throw new IllegalArgumentException("Unknown ticket type");
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(dto, String.class);
    }

    public String getTicketUrl(@NotNull Ticket ticket) {
        return webUrl + "/ticket/" + URLEncoder.encode(ticket.getJwt(), StandardCharsets.UTF_8);
    }
}
