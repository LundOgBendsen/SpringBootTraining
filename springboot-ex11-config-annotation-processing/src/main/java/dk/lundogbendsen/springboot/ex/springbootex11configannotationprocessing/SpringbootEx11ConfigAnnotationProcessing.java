package dk.lundogbendsen.springboot.ex.springbootex11configannotationprocessing;

import dk.lundogbendsen.springboot.ex.springbootex11configannotationprocessing.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(AppConfig.class)
public class SpringbootEx11ConfigAnnotationProcessing {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEx11ConfigAnnotationProcessing.class, args);
    }

}
