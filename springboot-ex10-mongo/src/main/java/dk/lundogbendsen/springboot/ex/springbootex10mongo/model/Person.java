package dk.lundogbendsen.springboot.ex.springbootex10mongo.model;

import org.springframework.data.annotation.Id;

public class Person {
    @Id
    public String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
