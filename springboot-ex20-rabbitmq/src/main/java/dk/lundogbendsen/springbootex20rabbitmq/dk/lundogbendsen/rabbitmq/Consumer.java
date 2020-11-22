package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RabbitListener(queues = ConsumerConfig.QUEUE)
public class Consumer {

    @RabbitHandler
    public void consume(String message) {
        System.out.println("STRING message = " + message);

        throw new AmqpRejectAndDontRequeueException("A RANDOM error happened");
    }

    @RabbitHandler
    public void consumePojo(MyMessage message) {
        System.out.println("POJO message = " + message);
    }

    @RabbitHandler
    public void consumeByteArray(byte[] message) {
        System.out.println("byte[] message = " + new String(message));
    }

    @RabbitHandler
    public void consumeJson(Map<String, Object> message) {
        System.out.println("JSON message = " + message);
    }
}
