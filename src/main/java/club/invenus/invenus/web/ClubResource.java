package club.invenus.invenus.web;

import club.invenus.invenus.service.ClubService;
import club.invenus.invenus.service.dto.ClubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClubResource {

    private final ClubService clubService;

    @Autowired
    ClubResource(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping(value = "/clubs", produces = {"application/json; charset=UTF-8"})
    public Collection<ClubDTO> getClubs() {
        return clubService.getClubs();
    }

    @GetMapping(value = "/clubs/{clubId}", produces = {"application/json; charset=UTF-8"})
    public Optional<ClubDTO> getClub(@PathVariable UUID clubId) {
        return clubService.getClub(clubId);
    }

}
