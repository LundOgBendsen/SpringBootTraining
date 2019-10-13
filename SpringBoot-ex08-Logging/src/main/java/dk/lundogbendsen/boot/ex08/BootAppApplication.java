package dk.lundogbendsen.boot.ex08;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootAppApplication {

	public static void main(String[] args) {
		// På dette punkt virker Logbacks default indstillinger (log-level: debug)
		Logger logger = LoggerFactory.getLogger(BootAppApplication.class.getName());

		logger.trace("BEFORE: A TRACE Message");
		logger.debug("BEFORE: A DEBUG Message");
		logger.info("BEFORE: An INFO Message");
		logger.warn("BEFORE: A WARN Message");
		logger.error("BEFORE: An ERROR Message");

        SpringApplication.run(BootAppApplication.class, args);

		// På dette punkt virker SpringBoots default indstillinger (log-level: info)
		logger.trace("AFTER: A TRACE Message");
		logger.debug("AFTER: A DEBUG Message");
		logger.info("AFTER: An INFO Message");
		logger.warn("AFTER: A WARN Message");
		logger.error("AFTER: An ERROR Message");

	}

	@Bean("solution1")
	public RestTemplate restTemplate2() {
		// Berig RestTemplate med en interceptor, der tilføjer en request header på alle udgående requests
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("X-TRACE-ID", MDC.get("TRACE_ID"));
			return execution.execute(request, body);
		});
		return restTemplate;
	}

	@Bean("solution2")
	public RestTemplate getRestTemplate() {
		// Bare brug out-of-the-box RestTemplate. Berigelse sker med Autoconfiguration i Sleuth starteren.
		return new RestTemplate();
	}


}
