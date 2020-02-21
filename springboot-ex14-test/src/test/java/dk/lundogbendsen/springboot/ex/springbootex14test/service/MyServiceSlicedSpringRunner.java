package dk.lundogbendsen.springboot.ex.springbootex14test.service;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex14test.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.security.auth.login.AppConfigurationEntry;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;


/**
 * Sliced SpringBoot application with only MyService and PersonRepository as Beans
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={MyService.class})
public class MyServiceSlicedSpringRunner {
    @MockBean
    private PersonRepository personRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MyService myService;

    @Before
    public void init() {
        Person person = new Person();
        person.setName("Christian");
        person.setId(1L);
        given(personRepository.getOne(1L)).willReturn(person);
    }

    @Test
    public void testGetPerson() {
        Person person = myService.get(1L);
        assertEquals(person.getName(), "Christian");
    }

}
