package club.invenus.invenus.service;

import club.invenus.invenus.repository.EventInstanceRepository;
import club.invenus.invenus.repository.EventRepository;
import club.invenus.invenus.service.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventInstanceRepository eventInstanceRepository;

    @Autowired
    EventService(EventRepository eventRepository, EventInstanceRepository eventInstanceRepository) {
        this.eventRepository = eventRepository;
        this.eventInstanceRepository = eventInstanceRepository;
    }

    @Transactional
    public Collection<EventDTO> getEvents() {
        return eventInstanceRepository.streamAll()
                .map(EventDTO::new)
                .toList();
    }

    @Transactional
    public Optional<EventDTO> getEvent(UUID eventId) {
        return eventInstanceRepository.findById(eventId)
                .map(EventDTO::new);
    }
}
