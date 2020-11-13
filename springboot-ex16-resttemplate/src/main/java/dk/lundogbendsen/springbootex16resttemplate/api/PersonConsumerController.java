package dk.lundogbendsen.springbootex16resttemplate.api;

import com.fasterxml.jackson.databind.JsonNode;
import dk.lundogbendsen.rest.assignment.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class PersonConsumerController {

    @Autowired
    RestTemplate restTemplate;



    @GetMapping("/personListEntity")
    public ResponseEntity<JsonNode> consumePersonListEntity() {
        String url = "http://localhost:8080/";
        final ResponseEntity<JsonNode> forEntity = restTemplate.getForEntity(url, JsonNode.class);
        return forEntity;
    }



    @GetMapping("/personListObject")
    public Person[] consumePersonListObject() {
        String url = "http://localhost:8080/";
        final Person[] forObject = restTemplate.getForObject(url, Person[].class);
        return forObject;

    }



    @GetMapping("/personListExchange")
    public ResponseEntity<Person[]> consumePersonListExchange() {
        String url = "http://localhost:8080/";
        RequestEntity<Person> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(url));
        final ResponseEntity<Person[]> exchange = restTemplate.exchange(requestEntity, Person[].class);
        // For fun add a header to the exchange before passing it as the response
        final HttpHeaders headers = exchange.getHeaders();
        final HttpHeaders httpHeaders = HttpHeaders.writableHttpHeaders(headers);
        httpHeaders.set("Course", "Lundogbendsen Springboot");
        final ResponseEntity<Person[]> responseEntity = new ResponseEntity<>(exchange.getBody(), httpHeaders, exchange.getStatusCode());
        return responseEntity;
    }




    @PostMapping("/createPerson")
    public String createPerson(@RequestParam String name, @RequestParam Long age) {
        String url = "http://localhost:8080/?name={name}&age={age}";
        final String postForObject = restTemplate.postForObject(url, null, String.class, name, age);
        return postForObject;
    }



}
