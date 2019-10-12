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
    public void contextLoads() {
        myService.get(1L);
    }

}
