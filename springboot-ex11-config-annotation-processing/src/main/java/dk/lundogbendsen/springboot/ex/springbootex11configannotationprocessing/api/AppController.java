package dk.lundogbendsen.springboot.ex.springbootex11configannotationprocessing.api;

import dk.lundogbendsen.springboot.ex.springbootex11configannotationprocessing.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    private AppConfig appConfig;

    @GetMapping
    public String getAppName() {
        String appName = appConfig.getAppName();
        return appName != null ? appName : "Not defined";
    }
}
