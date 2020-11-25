package dk.lundogbendsen.springboot.urlshortenerservice.controller;

import dk.lundogbendsen.springboot.urlshortenerservice.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping("/shorten/{token}")
    @ResponseStatus(HttpStatus.CREATED)
    public String shorten(@PathVariable String token, @RequestParam String url) {
        final String shorten = urlShortenerService.shorten(token, url);
        return shorten;
    }

    @GetMapping("/{token}")
    public ResponseEntity<Object> redirect(@PathVariable String token) {
        final String targetUrl = urlShortenerService.getTargetUrl(token);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header(HttpHeaders.LOCATION, targetUrl).build();
    }

    @DeleteMapping("/{token}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String token) {
        urlShortenerService.delete(token);
    }
}
