package dk.lundogbendsen.boot.ex09.precedence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PrecedenceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PrecedenceApplication.class, args);
        MyConfig myConfig = run.getBean("myConfig", MyConfig.class);
        System.out.println("myConfig.getApplicationSource() = " + myConfig.getApplicationSource());
    }

}
