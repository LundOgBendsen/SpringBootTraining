package dk.lundogbendsen.springboot.ex.springbootex10mongo.api;

import dk.lundogbendsen.springboot.ex.springbootex10mongo.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex10mongo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        Person save = personRepository.save(person);
        return save;
    }
}
