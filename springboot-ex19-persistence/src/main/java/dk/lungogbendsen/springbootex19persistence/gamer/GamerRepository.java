package dk.lungogbendsen.springbootex19persistence.gamer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Long> {}
