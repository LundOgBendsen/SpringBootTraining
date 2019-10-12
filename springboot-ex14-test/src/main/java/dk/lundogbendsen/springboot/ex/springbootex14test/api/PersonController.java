package dk.lundogbendsen.springboot.ex.springbootex14test.api;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex14test.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private MyService myService;

    public PersonController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping
    public Long createPerson(@RequestBody String name) {
        Person person = new Person();
        person.setName(name);

        Person createdPerson = myService.createPerson(person);
        return createdPerson.getId();
    }

    @GetMapping
    public Person get(Long id) {
        return myService.get(id);
    }
}
