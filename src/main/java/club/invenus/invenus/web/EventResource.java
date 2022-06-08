package club.invenus.invenus.web;

import club.invenus.invenus.service.EventService;
import club.invenus.invenus.service.dto.ClubDTO;
import club.invenus.invenus.service.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EventResource {

    private final EventService eventService;

    @Autowired
    EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/events", produces = {"application/json; charset=UTF-8"})
    public Collection<EventDTO> getEvents() {
        return eventService.getEvents();
    }

}
