package dk.lundogbendsen.springboot.ex.springbootex14test.service;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex14test.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceMockitoJUnitRunner {
    @Mock private PersonRepository personRepository;

    @InjectMocks
    private MyService myService;

    @Before
    public void init() {
        Person person = new Person();
        person.setName("Christian");
        person.setId(1L);
        given(personRepository.getOne(1L)).willReturn(person);
    }

    @Test
    // Denne test starter IKKE en SpringContext. Mocking foregår derfor manuelt.
    // Til gengæld kører testen lynhurtigt, som vi godt kan lide det med units.
    public void testGetPerson() {

        Person person = myService.get(1L);
        assertEquals(person.getName(), "Christian");
    }

}
