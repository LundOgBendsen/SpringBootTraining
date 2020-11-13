package dk.lundogbendsen.springbootex16resttemplate.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping
    public Object list() {
        return List.of(Map.of("name", "Christian", "age", 47));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam String name, @RequestParam Long age) {

    }

    @GetMapping("/headers")
    public ResponseEntity list(@RequestHeader String apiToken) {
        if (apiToken == null || !apiToken.equals("123")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
