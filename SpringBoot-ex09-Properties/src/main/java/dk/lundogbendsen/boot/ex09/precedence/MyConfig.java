package dk.lundogbendsen.boot.ex09.precedence;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("precedence")
public class MyConfig {
    private String applicationSource;

    public String getApplicationSource() {
        return applicationSource;
    }

    public void setApplicationSource(String applicationSource) {
        this.applicationSource = applicationSource;
    }
}
