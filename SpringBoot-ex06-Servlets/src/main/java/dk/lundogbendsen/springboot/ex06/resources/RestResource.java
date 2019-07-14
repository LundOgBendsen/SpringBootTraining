package dk.lundogbendsen.springboot.ex06.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RestResource {

    @RequestMapping("/resources")
    public String home() {
        StringBuilder sb = new StringBuilder("<h1>/Resources</h1>");
        return sb.toString();

    }
}
