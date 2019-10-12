package dk.lundogbendsen.springboot.ex.springbootex13aop;

import dk.lundogbendsen.springboot.ex.springbootex13aop.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootEx13AopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEx13AopApplication.class, args);

        // Get Service bean
        MyService myService = context.getBean("myService", MyService.class);

        // Execute business method - how many log statements?
        myService.randomPause(1000);

        // Execute business method - how many log statements?
        myService.doPause(1000);

    }

}
