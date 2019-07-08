package dk.lundogbendsen.springboot.ex04;

import dk.lundogbendsen.springboot.ex04.beans.Greeter;
import dk.lundogbendsen.springboot.ex04.beans.GreetingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	Greeter greeter;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public GreetingTranslator getTranslator() {
		System.out.println("getTranslator");
		return new GreetingTranslator();

	}

}
