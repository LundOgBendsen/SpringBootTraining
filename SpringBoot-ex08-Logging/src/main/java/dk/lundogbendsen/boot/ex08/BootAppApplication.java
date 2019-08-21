package dk.lundogbendsen.boot.ex08;


import dk.lundogbendsen.boot.ex08.resources.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootAppApplication {

	private static Logger logger = LoggerFactory.getLogger(BootAppApplication.class.getName());

	/*
	This method will be invoked by Spring with logging configuration given by Spring. We use this to demo
	the root logging level. See application.properties file.
	 */
	@Autowired
    public void setLoggingController(LoggingController c) {
	    logger.warn("Injection - (WARN)");
        logger.info("Injection - (INFO)");
    }

	public static void main(String[] args) {
		logger.info("Starting spring server (INFO)");
        logger.warn("Starting spring server (WARN)");

        SpringApplication.run(BootAppApplication.class, args);
	}
}
