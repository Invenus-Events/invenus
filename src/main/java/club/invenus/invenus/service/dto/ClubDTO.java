package club.invenus.invenus.service.dto;

import club.domain.club.Club;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClubDTO {

    public ClubDTO(@NotNull Club club) {

    }

}
