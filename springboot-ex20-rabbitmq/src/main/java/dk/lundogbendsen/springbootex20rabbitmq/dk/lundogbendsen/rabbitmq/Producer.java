package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq.ProducerConfig.EXCHANGE;
import static dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq.ProducerConfig.ROUTINGKEY;

@Service
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Object message) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTINGKEY, message);
    }

    public void sendMessageJson(Object pojo) throws JsonProcessingException {
        Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(pojo))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();
        rabbitTemplate.send(EXCHANGE, ROUTINGKEY, message);
    }
}
