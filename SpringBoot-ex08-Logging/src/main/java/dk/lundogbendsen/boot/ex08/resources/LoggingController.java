package dk.lundogbendsen.boot.ex08.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    @Qualifier("solution1")
    private RestTemplate solution1RestTemplate;

    @Autowired
    @Qualifier("solution2")
    private RestTemplate solution2RestTemplate;


    @RequestMapping("/")
    public String index(WebRequest webRequest) {
        // Normalt vil det ikke være et concern i controlleren, at administrere et traceId
        String traceId = webRequest.getHeader("X-TRACE-ID");
        if (traceId == null) {
            traceId = UUID.randomUUID().toString();
        }
        MDC.put("TRACE_ID", traceId);

        try {
            logger.trace("A TRACE Message");
            logger.debug("A DEBUG Message");
            logger.info("An INFO Message");
            logger.warn("A WARN Message");
            logger.error("An ERROR Message");

            return "Hello from LoggingController! " + System.currentTimeMillis();
        } finally {
            MDC.clear();
        }
    }

    @RequestMapping("/solution1")
    public String callHome1() {
        MDC.put("TRACE_ID", UUID.randomUUID().toString());
        logger.trace("calling home");
        return solution1RestTemplate.getForObject("http://localhost:8080", String.class);
    }


    @RequestMapping("/solution2")
    public String callHome2() {
        logger.trace("calling home");
        return solution2RestTemplate.getForObject("http://localhost:8080", String.class);
    }
}
