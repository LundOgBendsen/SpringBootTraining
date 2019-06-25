package dk.lundogbendsen.springboot.ex01.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name")String name) {
        return "Hello, " + name;
    }

}
