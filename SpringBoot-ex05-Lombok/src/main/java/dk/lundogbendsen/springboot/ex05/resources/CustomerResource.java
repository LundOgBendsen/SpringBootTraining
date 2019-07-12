package dk.lundogbendsen.springboot.ex05.resources;

import dk.lundogbendsen.springboot.ex05.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CustomerResource {
    @RequestMapping("/customers/1")
    public Customer cust1() {
        Customer customer = new Customer();
        //note that the customer object has all get'ers and set'ers thanks to Lombok.
        customer.setId(1L);
        customer.setCreated(new Date());
        customer.setEmail("id@id.org");
        customer.setName("James Gosling");
        return customer;
    }

    @RequestMapping("/customers")
    public String home() {
        StringBuilder sb = new StringBuilder("<h1>/customers</h1>");

        Customer c1 = new Customer();
        //note that the customer object has all get'ers and set'ers thanks to Lombok.
        c1.setId(1L);
        c1.setCreated(new Date());
        c1.setEmail("id@id.org");
        c1.setName("James Gosling");

        sb.append("<p>toString(): ").append(c1.toString()).append("</p>");

        Customer c2 = new Customer();
        //note that the customer object has all get'ers and set'ers thanks to Lombok.
        c2.setId(1L);
        c2.setCreated(new Date());
        c2.setEmail("id@id.org");
        c2.setName("James Gosling");

        sb.append("<p>c1.equals(c2): ").append(c1.equals(c2)).append("</p>");


        return sb.toString();

    }
}
