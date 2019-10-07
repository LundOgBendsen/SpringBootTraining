package dk.lundogbendsen.boot.properties.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource3 {
    @Value("${JAVA_HOME}")
    private String stringValue;

    @RequestMapping("/3")
    public String home() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Properties from operation system</h1>");

        sb.append("<p>JAVA_HOME: ");
        sb.append(stringValue).append("</p>");
        return sb.toString();
    }
}
