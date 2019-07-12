package dk.lundogbendsen.springboot.ex05.resources;

import dk.lundogbendsen.springboot.ex05.model.Car;
import dk.lundogbendsen.springboot.ex05.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CarResource {
    @RequestMapping("/cars/1")
    public String car1() {
        Car car = new Car("ford", "focus", 2016);
        //notice the generated get'ers. there are no set'ers
        return "Car[" + car.getMaker() + ", " + car.getModel() + ", " + car.getYear() + "]";
    }
}
