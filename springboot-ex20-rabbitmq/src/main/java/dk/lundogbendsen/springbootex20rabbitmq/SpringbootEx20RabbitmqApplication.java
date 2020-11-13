package dk.lundogbendsen.springbootex20rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq.AwsProducer;
import dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq.MyMessage;
import dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq.Producer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringbootEx20RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEx20RabbitmqApplication.class, args);
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public CommandLineRunner demo(Producer producer) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                if (Math.random() > 0.5) {
                    producer.sendMessageJson("Hello World! " + i);
                } else {
                    producer.sendMessageJson(new MyMessage("Hello world " + i, new Date()));
                }

            }
        };
    }

//    @Bean
    public CommandLineRunner demoAws(AwsProducer producer) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                producer.sendMessage("Hello World! " + i);
            }
        };
    }

}
