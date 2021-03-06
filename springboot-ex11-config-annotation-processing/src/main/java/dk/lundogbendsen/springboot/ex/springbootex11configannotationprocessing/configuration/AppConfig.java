package dk.lundogbendsen.springboot.ex.springbootex11configannotationprocessing.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ex11")
public class AppConfig {
	/**
	 * The App Name
	 */
    private String appName = "the App";
    /**
     * An app must have a Color!
     */
    private Colors colors = Colors.RED;

    public Colors getColors() {
        return colors;
    }

    public void setColors(Colors colors) {
        this.colors = colors;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
