package dk.lundogbendsen.springbootex17actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MyAppInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("Team", "Team Awesome");
        builder.withDetail("Project", "The Future");
    }
}
