package dk.lundogbendsen.springboot.ex.springbootex10mongo.repository;

import dk.lundogbendsen.springboot.ex.springbootex10mongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
