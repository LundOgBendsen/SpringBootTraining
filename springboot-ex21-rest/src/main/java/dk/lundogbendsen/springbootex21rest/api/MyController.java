package dk.lundogbendsen.springbootex21rest.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MyController {
    @PostMapping("/object/{id}")
    public Map<String, Object> getObject(
            @PathVariable String id,
            @RequestHeader(name = "Content-Type") String contentType,
            @RequestParam String color,
            @RequestBody String content) {
        return Map.of("id", id, "color", color, "Content", content);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String getObject() {
        return "Funny times back then...";
    }


    @GetMapping("/complete-control")
    public ResponseEntity<String> completeControl() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Your body is accepted");
    }
}
