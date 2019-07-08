package dk.lundogbendsen.springboot.ex04.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Greeter {

    @Autowired
    private GreetingTranslator translator;

    public String getGreeting() {
        return "Hello from Greeter!";
    }
}
