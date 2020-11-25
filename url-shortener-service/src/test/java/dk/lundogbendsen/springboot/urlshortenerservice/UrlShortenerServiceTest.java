package dk.lundogbendsen.springboot.urlshortenerservice;

import dk.lundogbendsen.springboot.urlshortenerservice.service.TokenAlreadyExistsException;
import dk.lundogbendsen.springboot.urlshortenerservice.service.UrlShortenerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlShortenerServiceTest {

    private UrlShortenerService urlShortenerService = new UrlShortenerService();

    @Test
    public void testShortenUrl() {
        String abc = urlShortenerService.shorten("abc", "http://dr.dk");
        assertEquals("abc", abc);
    }

    @Test
    public void testResolveToken() {
        String abc = urlShortenerService.shorten("abc", "http://dr.dk");
        assertEquals("abc", abc);

        String url = urlShortenerService.getTargetUrl(abc);
        assertEquals("http://dr.dk", url);

    }

    @Test
    public void testUpdateTokenGivesException() {
        String abc = urlShortenerService.shorten("abc", "http://dr.dk");
        assertEquals("abc", abc);


        try {
            abc = urlShortenerService.shorten("abc", "http://example.com");
            fail("Code should have failed");
        } catch (Exception e) {
            assertTrue(e instanceof TokenAlreadyExistsException);
        }

    }
}
