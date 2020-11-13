package dk.lundogbendsen.springbootex20rabbitmq.dk.lundogbendsen.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyMessage {
    private String message;
    private Date when;
//    public MyMessage(String message, Date when) {
//        this.message=message;
//        this.when=when;
//    }
//    public MyMessage() {
//
//    }
}
