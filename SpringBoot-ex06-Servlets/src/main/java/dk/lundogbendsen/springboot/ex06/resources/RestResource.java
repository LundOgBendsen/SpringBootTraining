package dk.lundogbendsen.springboot.ex06.resources;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RestResource {

    Logger logger = LoggerFactory.getLogger(RestResource.class);

    @RequestMapping("/resources")
    public String home() {
        logger.info("ENTER home()");
        final ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
        jsonNodes.put("firstName", "Christian");
        jsonNodes.put("lastName", "Jensen");
        logger.info("EXIT home()");
        return jsonNodes.asText();
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin";
    }
}
