package dk.lundogbendsen.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dk.lundogbendsen.boot.dao.AccountRepository;

@SpringBootApplication
public class BootAppApplication  {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AccountRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BootAppApplication.class, args);
	}
}
