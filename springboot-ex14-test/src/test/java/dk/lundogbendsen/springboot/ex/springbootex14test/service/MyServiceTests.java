package dk.lundogbendsen.springboot.ex.springbootex14test.service;

import dk.lundogbendsen.springboot.ex.springbootex14test.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTests {
    @Mock private PersonRepository personRepository;

    @InjectMocks
    private MyService myService;


    @Test
    // Denne test starter IKKE en SpringContext. Mocking foregår derfor manuelt.
    // Til gengæld kører testen lynhurtigt, som vi godt kan lide det med units.
    public void contextLoads() {
        myService.get(1L);
    }

}
