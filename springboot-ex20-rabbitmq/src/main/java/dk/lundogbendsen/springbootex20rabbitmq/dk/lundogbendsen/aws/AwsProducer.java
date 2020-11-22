package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.aws;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwsProducer {
    @Autowired AmazonSQSAsync amazonSQSAsync;

    public void sendMessage(String message) {
        amazonSQSAsync.sendMessage("myQueue", message);
    }
}
