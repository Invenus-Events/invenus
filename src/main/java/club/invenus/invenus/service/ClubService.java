package club.invenus.invenus.service;

import club.invenus.invenus.repository.ClubRepository;
import club.invenus.invenus.service.dto.ClubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Transactional
    public Collection<ClubDTO> getClubs() {
        return clubRepository.streamAll()
                .map(ClubDTO::new)
                .toList();
    }

    @Transactional
    public Optional<ClubDTO> getClub(UUID uuid) {
        return clubRepository.findById(uuid)
                .map(ClubDTO::new);
    }

}
