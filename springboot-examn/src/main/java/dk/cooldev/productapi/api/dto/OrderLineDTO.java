package dk.cooldev.productapi.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderLineDTO {
    private String productName;
    private Double productPrice;
    private Integer amount;
    private Double orderLinePrice;
}
