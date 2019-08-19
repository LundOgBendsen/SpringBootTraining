package dk.lundogbendsen.springboot.ex05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pet {
    private String name;
    private Customer owner;
}

