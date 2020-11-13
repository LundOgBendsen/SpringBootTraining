package dk.lundogbendsen.springbootex16resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootEx16ResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEx16ResttemplateApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
