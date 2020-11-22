package dk.lundogbendsen.springbootex20rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.aws.AwsProducer;
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
        final ObjectMapper mapper = new ObjectMapper();
//        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    @Bean
    public CommandLineRunner demoDefault(Producer producer) {
        return args -> {
            producer.sendMessage("Hello World: Default settings! ");

        };
    }

    //    @Bean
    public CommandLineRunner demoPojo(Producer producer) {
        return args -> {
            producer.sendMessage(new MyMessage("Hello world: Pojo ", new Date()));
        };
    }

    //    @Bean
    public CommandLineRunner demoJson(Producer producer) {
        return args -> {
            producer.sendMessageJson(new MyMessage("Hello world: Pojo ", new Date()));
        };
    }

    //    @Bean
    public CommandLineRunner demoAws(AwsProducer producer) {
        return args -> {
            producer.sendMessage("Hello World: AWS/SQS");
        };
    }


}
