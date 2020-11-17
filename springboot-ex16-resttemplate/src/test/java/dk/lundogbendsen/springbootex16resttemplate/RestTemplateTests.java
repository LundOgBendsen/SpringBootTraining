package dk.lundogbendsen.springbootex16resttemplate;

import com.fasterxml.jackson.databind.JsonNode;
import dk.lundogbendsen.rest.assignment.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
class RestTemplateTests {

	RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8081/example";

	@Test
	void testConsumeListAsEntity() {
		final ResponseEntity<Person[]> forEntity = restTemplate.getForEntity(url, Person[].class);
		assertEquals(HttpStatus.OK, forEntity.getStatusCode());
		assertEquals(1, forEntity.getBody().length);
		assertEquals("Christian", forEntity.getBody()[0].getName());
	}

	@Test
	public void testConsumeListOfObjects() {
		final Person[] response = restTemplate.getForObject(url, Person[].class);
		assertEquals("Christian", response[0].getName());
	}


	@Test
	public void testConsumeXml() {

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
		String url = "http://localhost:8081/example?name={name}&age={age}";
		restTemplate.postForObject(url, null, void.class, "Christian", 47);
	}


	@Test
	public void testHeadersApiTokenAccepted() {
		String url = "http://localhost:8081/example/headers";

		HttpHeaders headers = new HttpHeaders();
		headers.add("apiToken", "123");
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		final ResponseEntity<Void> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, void.class);

		assertEquals(HttpStatus.OK,exchange.getStatusCode());
	}

	@Test
	public void testHeadersApiTokenNotAccepted() {
		String url = "http://localhost:8081/example/headers";

		HttpHeaders headers = new HttpHeaders();
		headers.add("apiToken", "666");
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		try {
			ResponseEntity<Void> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, void.class);
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