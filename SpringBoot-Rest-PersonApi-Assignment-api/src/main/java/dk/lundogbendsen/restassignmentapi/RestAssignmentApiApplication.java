package dk.lundogbendsen.restassignmentapi;

import dk.lundogbendsen.rest.assignment.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestAssignmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAssignmentApiApplication.class, args);
	}

	@Bean
	public PersonService personService() {
		return new PersonService();
	}
}
