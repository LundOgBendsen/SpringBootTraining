package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RabbitListener(queues = ConsumerConfig.QUEUE)
public class Consumer {

    @RabbitHandler
    public void consume(String message) {
        System.out.println("message = " + message);

        if (Math.random() > 0.5) {
            throw new AmqpRejectAndDontRequeueException("An error happened");
        }
    }

    @RabbitHandler
    public void consumeJson(Map<String, Object> message) {
        System.out.println("message = " + message);
    }
}
