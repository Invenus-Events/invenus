package club.invenus.invenus.web;

import club.invenus.invenus.service.ClubService;
import club.invenus.invenus.service.dto.ClubDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ClubResource {

    private final ClubService clubService;

    @Autowired
    ClubResource(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public Collection<ClubDTO> getClubs() {
        return clubService.getClubs();
    }

}
