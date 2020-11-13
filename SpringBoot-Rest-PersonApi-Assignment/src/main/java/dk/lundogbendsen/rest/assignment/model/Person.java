package dk.lundogbendsen.rest.assignment.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private Long id;
    private String name;
    private Long age;
}
