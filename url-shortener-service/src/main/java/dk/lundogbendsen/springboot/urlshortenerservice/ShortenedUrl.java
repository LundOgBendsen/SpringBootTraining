package dk.lundogbendsen.springboot.urlshortenerservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ShortenedUrl {
    @Id
    @GeneratedValue
    Long id;
    String token;
    String url;
}
