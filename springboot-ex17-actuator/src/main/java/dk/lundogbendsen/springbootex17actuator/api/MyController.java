package dk.lundogbendsen.springbootex17actuator.api;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MeterRegistry meterRegistry;

    @PostMapping
    public void sendData(@RequestBody String data) {
        meterRegistry.counter("content-size", "unit", "chars").increment(data.length());
        System.out.println("data = " + data);
    }
}
