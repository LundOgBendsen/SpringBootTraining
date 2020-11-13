package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class AwsConsumer {
    @SqsListener(value = "myQueue")
    public void onMessage(String message) {
        System.out.println("message = " + message);
    }
}
