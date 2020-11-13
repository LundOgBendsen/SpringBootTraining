package dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.api;

import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service.PersonService;
import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service.exception.NotFoundServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PersonController implements ErrorController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person1/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@PathVariable String name) {
        return personService.create(name);
    }

    @PostMapping("/person2/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPersonFail(@PathVariable String name) {
        return personService.createAndFail(name);
    }

    @PostMapping("/person3/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPersonFailWithNonServiceException(@PathVariable String name) {
        return personService.createAndDatabaseError(name);
    }

    @GetMapping("/person/{id}")
//    @ResponseStatus(HttpStatus.OK) // Not necessary because OK is default response
    public Person getAndFail(@PathVariable Long id) {
        return personService.getAndFail(id);
    }

//    @ExceptionHandler(NotFoundServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(Exception exception) {
        return "ControllerHandler: You have been baaad....";
    }

    @RequestMapping("/error")
    public ResponseEntity<Object> errorHandler(HttpServletRequest request) {
        return ResponseEntity.badRequest().body("Baaad...");
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
