package dk.cooldev.productapi.api.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateOrderRequest {
    private String email;
    private Map<String, Integer> products;
}
