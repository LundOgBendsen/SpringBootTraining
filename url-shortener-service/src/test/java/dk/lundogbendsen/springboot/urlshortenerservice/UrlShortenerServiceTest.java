package dk.lundogbendsen.springboot.urlshortenerservice;

import dk.lundogbendsen.springboot.urlshortenerservice.model.ShortenedUrl;
import dk.lundogbendsen.springboot.urlshortenerservice.repository.ShortenedUrlRepository;
import dk.lundogbendsen.springboot.urlshortenerservice.service.TokenAlreadyExistsException;
import dk.lundogbendsen.springboot.urlshortenerservice.service.UrlShortenerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UrlShortenerServiceTest {

    @Mock
    ShortenedUrlRepository shortenedUrlRepository;
    @InjectMocks
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


        // Setup canned answer
        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setToken("abc");
        shortenedUrl.setUrl("http://dr.dk");
        Optional<ShortenedUrl> optional = Optional.of(shortenedUrl);
        when(shortenedUrlRepository.findByToken("abc")).thenReturn(optional);


        // Test resolve
        String url = urlShortenerService.getTargetUrl(abc);
        assertEquals("http://dr.dk", url);

    }

    @Test
    public void testUpdateTokenGivesException() {
        String abc = urlShortenerService.shorten("abc", "http://dr.dk");
        assertEquals("abc", abc);

        // Setup canned answer
        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setToken("abc");
        shortenedUrl.setUrl("http://dr.dk");
        Optional<ShortenedUrl> optional = Optional.of(shortenedUrl);
        when(shortenedUrlRepository.findByToken("abc")).thenReturn(optional);


        try {
            abc = urlShortenerService.shorten("abc", "http://example.com");
            fail("Code should have failed");
        } catch (Exception e) {
            assertTrue(e instanceof TokenAlreadyExistsException);
        }

    }
}
