package dk.lundogbendsen.springboot.ex05.model;


import lombok.Getter;


//a lomboked class with only getters.

@Getter
public class Car {
    String maker;
    String model;
    int year;

    public Car(String maker, String model, int year) {
        this.maker = maker;
        this.model = model;
        this.year = year;
    }
}
