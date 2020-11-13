package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProducerForceConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Bean
    public RabbitAdmin rabbitAdmin(@Qualifier("rabbitConnectionFactory") ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Autowired
    RabbitAdmin rabbitAdmin;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Eager declare Exchange!");
        rabbitAdmin.initialize();
    }


}
