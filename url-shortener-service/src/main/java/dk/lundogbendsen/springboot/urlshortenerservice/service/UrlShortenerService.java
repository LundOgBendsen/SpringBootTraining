package dk.lundogbendsen.springboot.urlshortenerservice.service;

import dk.lundogbendsen.springboot.urlshortenerservice.model.ShortenedUrl;
import dk.lundogbendsen.springboot.urlshortenerservice.repository.ShortenedUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UrlShortenerService {

    @Autowired
    ShortenedUrlRepository shortenedUrlRepository;

    private Map<String, String> tokens = new HashMap<String, String>();

    public String shorten(String suggestedToken, String url) {
        Optional<ShortenedUrl> shortenedUrl = shortenedUrlRepository.findByToken(suggestedToken);
        if (shortenedUrl.isPresent()) {
            throw new TokenAlreadyExistsException();
        }

        ShortenedUrl shortened = new ShortenedUrl();
        shortened.setToken(suggestedToken);
        shortened.setUrl(url);
        shortenedUrlRepository.save(shortened);

        return suggestedToken;
    }

    public void delete(String token) {
        Optional<ShortenedUrl> shortenedUrl = shortenedUrlRepository.findByToken(token);
        if (shortenedUrl != null) {
            shortenedUrlRepository.delete(shortenedUrl.get());
        }
    }

    public String getTargetUrl(String token) {
        final Optional<ShortenedUrl> shortenedUrl = shortenedUrlRepository.findByToken(token);
        if (shortenedUrl.isPresent()) {
            return shortenedUrl.get().getUrl();
        } else {
            return null;
        }

    }
}
