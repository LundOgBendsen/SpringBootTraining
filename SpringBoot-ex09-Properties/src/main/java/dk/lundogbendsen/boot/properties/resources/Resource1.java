package dk.lundogbendsen.boot.properties.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource1 {
    @Value("${string-from-application-properties}")
    private String stringValue;

    @Value("${int-from-application-properties}")
    private Integer intValue;

    @Value("${string2-from-application-properties}")
    private String string2Value;

    @Value("${random-int-from-application-properties}")
    private Integer int2Value;

    @RequestMapping("/1")
    public String home() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Properties from application.properties</h1>");

        sb.append("<p>A string value from application.properties: ");
        sb.append(stringValue).append("</p>");

        sb.append("<p>An integer value from application.properties: ");
        sb.append(intValue).append("</p>");

        sb.append("<p>A composite integer value from application.properties: ");
        sb.append(string2Value).append("</p>");

        sb.append("<p>A random int value from application.properties: ");
        sb.append(int2Value).append("</p>");
        return sb.toString();
    }
}
