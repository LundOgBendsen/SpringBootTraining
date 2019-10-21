package dk.lundogbendsen.springboot.ex.springbootex14test.api;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void exampleTest() {
        ResponseEntity<Long> id = this.restTemplate.postForEntity("/", "Christian", Long.class);
        assertThat(id.getBody()).isEqualTo(1L);
    }
    @Test
    public void getPersonTest() {
        ResponseEntity<Person> person = this.restTemplate.getForEntity("/1", Person.class);
        assertThat(person.getBody().getId()).isEqualTo(1L);
    }
}
