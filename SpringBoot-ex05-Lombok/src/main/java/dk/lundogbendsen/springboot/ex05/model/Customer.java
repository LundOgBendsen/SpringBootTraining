package dk.lundogbendsen.springboot.ex05.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(exclude = {"created"}) //exclude 'created' field when comparing customers
public class Customer {
    private String name;
    private Long id;
    private String email;
    private Date created;
}
