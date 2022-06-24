package club.invenus.invenus.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {

    private final List<ProductDTO> products;

}
