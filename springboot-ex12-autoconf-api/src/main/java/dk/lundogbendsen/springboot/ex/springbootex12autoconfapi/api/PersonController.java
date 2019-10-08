package dk.lundogbendsen.springboot.ex.springbootex12autoconfapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }
}
