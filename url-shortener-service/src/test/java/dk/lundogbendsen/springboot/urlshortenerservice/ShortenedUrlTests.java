package dk.lundogbendsen.springboot.urlshortenerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Application.class})
public class ShortenedUrlTests {
    @Autowired
    UrlShortenerService urlShortenerService;

    @Test
    public void givenTokenAndUrl_saveInDatabase() {
        final String abc = urlShortenerService.shorten("abc", "https://google.com");
        final String url = urlShortenerService.getTargetUrl("abc");
        assertEquals("https://google.com", url);
    }
}
