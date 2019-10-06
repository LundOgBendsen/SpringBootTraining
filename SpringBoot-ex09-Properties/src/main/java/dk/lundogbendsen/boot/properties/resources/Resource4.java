package dk.lundogbendsen.boot.properties.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Run with Program arguments: --spring.config.name=yamldemo
 *
 * Test with: http://localhost:8080/3
 */

@RestController
public class Resource4 {
    @Value("${string-from-application-properties}")
    private String stringValue;

    @Value("${int-from-application-properties}")
    private Integer intValue;

    @Value("${string2-from-application-properties}")
    private String string2Value;

    @Value("${company.info.address.number}")
    private Integer streetNumber;

    @Value("${company.info.name}")
    private String company;

    @Value("${company.info.address.street}")
    private String street;

    @Value("${company.info.address.zip}")
    private Integer zip;

    @Value("${company.info.address.city}")
    private String city;

    @Value("${company.info.address.country}")
    private String country;

    @RequestMapping("/3")
    public String home() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Properties from yamldemo.yml</h1>");

        sb.append("<p>A string value from yamldemo.yml: ");
        sb.append(stringValue).append("</p>");

        sb.append("<p>An integer value from yamldemo.yml: ");
        sb.append(intValue).append("</p>");

        sb.append("<p>A composite string value from yamldemo.yml: ");
        sb.append(string2Value).append("</p>");

        sb.append("<p>Company address: ");
        sb.append(company).append(", ").append(street).append(" ").append(streetNumber);
        sb.append(", ").append(zip).append(" ").append(city).append(", ");
        sb.append(country).append("</p>");
        return sb.toString();
    }
}
