package dk.lundogbendsen.springbootex17actuator;

import io.micrometer.core.instrument.Counter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootEx17ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEx17ActuatorApplication.class, args);
	}

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

//	public Counter counter() {
//		Counter.builder("content-size").baseUnit("chars").
//
//	}
}
