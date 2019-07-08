package dk.lundogbendsen.springboot.ex04.resources;

import dk.lundogbendsen.springboot.ex04.beans.Greeter;
import dk.lundogbendsen.springboot.ex04.beans.GreetingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Greeting {

    GreetingTranslator translator;

    //one way of injection - field injection
    @Autowired
    Greeter greeter;

    //another way of injection - constructor injection
    public Greeting(@Autowired GreetingTranslator translator) {
        this.translator = translator;
    }

    @RequestMapping("/")
    public String home() {
        String greeting = greeter.getGreeting();
        return translator.translate(greeting, Locale.ENGLISH, Locale.FRENCH);
    }



    //a third way of DI: using setter methods to inject
    Greeter greeter2;
    @Autowired
    private void setGreeter(Greeter greeter) {
        System.out.println("SetGreeter");
        this.greeter2 = greeter;
    }
}
