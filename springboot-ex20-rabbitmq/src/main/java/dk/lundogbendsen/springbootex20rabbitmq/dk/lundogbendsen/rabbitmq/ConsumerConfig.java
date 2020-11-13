package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    @Autowired
    Exchange topicExchange;
    public static final String EXCHANGE_DLX = "consumer.t-dlx";
    public static final String QUEUE = "consumer.messages.q";
    public static final String QUEUE_DL = "consumer.messages.dlq";
    @Bean
    public TopicExchange topicExchangeDlx() {
        return ExchangeBuilder.topicExchange(EXCHANGE_DLX).build();
    }
    @Bean
    public Queue topicQueue() {
        return QueueBuilder.durable(QUEUE).deadLetterExchange(EXCHANGE_DLX).build();
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange).with(ProducerConfig.ROUTINGKEY).noargs();
    }
    @Bean
    public Queue topicQueueDl() {
        return QueueBuilder.durable(QUEUE_DL).build();
    }
    @Bean
    public Binding bindingDl() {
        return BindingBuilder.bind(topicQueueDl()).to(topicExchangeDlx()).with(ProducerConfig.ROUTINGKEY);
    }
}
