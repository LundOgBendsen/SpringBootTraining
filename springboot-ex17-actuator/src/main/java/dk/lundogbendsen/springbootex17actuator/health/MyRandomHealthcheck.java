package dk.lundogbendsen.springbootex17actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyRandomHealthcheck implements HealthIndicator {
    @Override
    public Health health() {
        if (Math.random() > .5) {
            return Health.down().build();
        }
        return Health.up().build();
    }
}
