package dk.cooldev.productapi.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class OrderDTO {
    private Long orderId;
    private String email;
    private List<OrderLineDTO> orderLines;
    private Double orderSum;
    private Date orderDate;
}
