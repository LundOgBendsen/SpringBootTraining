package dk.lundogbendsen.springbootex18scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootEx18SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEx18SchedulerApplication.class, args);
	}

	@Bean
	public HeavyJobService heavyJobService() {
		System.out.println("Preparing HEAVY Job Bean");
		return new HeavyJobService();
	}
//	@Bean
	public ScheduledService scheduledService() {
		System.out.println("Preparing light Job Bean");
		return new ScheduledService();
	}
}
