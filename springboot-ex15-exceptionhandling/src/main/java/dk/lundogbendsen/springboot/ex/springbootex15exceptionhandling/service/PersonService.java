package dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service;

import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service.exception.NotFoundServiceException;
import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLTimeoutException;

@Service
@Slf4j
public class PersonService {

    // create always fail with ServiceException - maybe it is because name is not unique.
    public Person createAndFail(String name) {
        log.error("Person could not be created because I didn't like the name. Or maybe the name already exists.");
        throw new ServiceException("Failed");
    }

    // create always fails because an exception of external origin occurred
    public Person createAndDatabaseError(String name) {
        log.error("Person could not be created because the database exploded. This is NOT a Service fault. Therefore don't throw ServiceException");
        SQLTimeoutException dbError = new SQLTimeoutException("Connection to database timed out");
        throw new RuntimeException(dbError);
    }

    // create succeed
    public Person create(String name) {
        return Person.builder().name(name).build();
    }

    // find fails because ID does not exist
    public Person getAndFail(Long id) {
        log.error("Person could not be found by the ID provided. Since there was an ID, the user must have expected that person to exists. Very Strange. This is worthy of a special Exception!");
        throw new NotFoundServiceException("Not person with ID " + id);
    }
}
