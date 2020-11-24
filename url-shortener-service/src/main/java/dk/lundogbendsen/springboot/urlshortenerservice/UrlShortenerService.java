package dk.lundogbendsen.springboot.urlshortenerservice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShortenerService {

    private Map<String, String> tokens = new HashMap<String, String>();

    public String shorten(String suggestedToken, String url) {
        if (tokens.containsKey(suggestedToken)) {
            throw new TokenAlreadyExistsException();
        }

        tokens.put(suggestedToken, url);

        return suggestedToken;
    }

    public void delete(String token) {
        tokens.remove(token);
    }

    public String getTargetUrl(String token) {
        return tokens.get(token);
    }
}
