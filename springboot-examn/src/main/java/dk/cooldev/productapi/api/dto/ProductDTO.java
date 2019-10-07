package dk.cooldev.productapi.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDTO {
    private String name;
    private Double price;
}
