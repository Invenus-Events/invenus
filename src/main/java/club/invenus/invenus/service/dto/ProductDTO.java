package club.invenus.invenus.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {

    private final UUID ticketId;
    private final int amount;

}
