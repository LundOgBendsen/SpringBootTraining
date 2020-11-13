package dk.lundogbendsen.springboot.ex.springbootex14test.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerFullSpringBootRealHttp {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void exampleTest() {
        // This is a live request to the actual running springboot server. Data will be stored in a memory database (H2)
        ResponseEntity<Long> id = this.restTemplate.postForEntity("/", "Christian", Long.class);
        assertThat(id.getBody()).isEqualTo(1L);
    }
}
