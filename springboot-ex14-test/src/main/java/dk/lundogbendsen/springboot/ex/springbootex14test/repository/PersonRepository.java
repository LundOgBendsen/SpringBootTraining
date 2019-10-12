package dk.lundogbendsen.springboot.ex.springbootex14test.repository;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
