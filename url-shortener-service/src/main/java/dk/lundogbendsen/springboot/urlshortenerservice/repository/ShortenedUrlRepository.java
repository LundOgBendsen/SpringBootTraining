package dk.lundogbendsen.springboot.urlshortenerservice.repository;

import dk.lundogbendsen.springboot.urlshortenerservice.model.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortenedUrlRepository extends JpaRepository<ShortenedUrl, Long> {
    Optional<ShortenedUrl> findByToken(String token);
}
