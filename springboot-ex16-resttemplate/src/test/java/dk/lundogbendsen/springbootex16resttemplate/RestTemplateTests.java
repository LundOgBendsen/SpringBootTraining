package dk.lundogbendsen.springbootex16resttemplate;

import com.fasterxml.jackson.databind.JsonNode;
import dk.lundogbendsen.rest.assignment.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateTests {

    @Autowired
    private RestTemplate restTemplate;

    @LocalServerPort
    private int port;
	private String url;

	@BeforeEach
    public void init() {
        url = "http://localhost:" + port + "/example";
    }

    @Test
    void testConsumeListAsEntity() {
        final ResponseEntity<Person[]> forEntity = restTemplate.getForEntity(url, Person[].class);
        assertEquals(HttpStatus.OK, forEntity.getStatusCode());
        assertEquals(1, forEntity.getBody().length);
        assertEquals("application/json", forEntity.getHeaders().getContentType().toString());
        assertEquals("Christian", forEntity.getBody()[0].getName());
    }

    @Test
    public void testConsumeListOfObjects() {
        final Person[] response = restTemplate.getForObject(url, Person[].class);
        assertEquals("Christian", response[0].getName());
    }


//    @Test
    public void testConsumeXml() {
        // Must add an XML handler to pom.xml:
/*
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
		</dependency>
*/

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        final ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        System.out.println("exchange.getBody() = " + exchange.getBody());
    }

    @Test
    public void testConsumeJson() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        final ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        System.out.println("exchange.getBody() = " + exchange.getBody());
    }


    @Test
    public void testConsumeListUsingExchange() {
        RequestEntity<Person> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(url));
        final ResponseEntity<Person[]> response = restTemplate.exchange(requestEntity, Person[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().length);
        assertEquals("Christian", response.getBody()[0].getName());
    }


    @Test
    public void testTemplateSubstitution() {
        String template = url + "?name={name}&age={age}";
        restTemplate.postForObject(template, null, void.class, "Christian", 47);
    }


    @Test
    public void testHeadersApiTokenAccepted() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("apiToken", "123");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        final ResponseEntity<Void> exchange = restTemplate.exchange(url + "/headers", HttpMethod.GET, requestEntity, void.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }

    @Test
    public void testHeadersApiTokenNotAccepted() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("apiToken", "666");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        try {
            ResponseEntity<Void> exchange = restTemplate.exchange(url + "/headers", HttpMethod.GET, requestEntity, void.class);
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }

    }


    @Test
    public void testJokesApi() {
        final String jokesUrl = "http://api.icndb.com/jokes/random?firstName={firstName}&lastName={lastName}";
        final JsonNode forObject = restTemplate.getForObject(jokesUrl, JsonNode.class, "chuck", "norris");
        System.out.println("forObject.get(\"value\").get(\"joke\").asText() = " + forObject.get("value").get("joke").asText());

    }


}
