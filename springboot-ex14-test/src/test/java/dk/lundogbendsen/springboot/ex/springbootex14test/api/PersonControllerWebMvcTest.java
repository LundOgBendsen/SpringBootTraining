package dk.lundogbendsen.springboot.ex.springbootex14test.api;

import dk.lundogbendsen.springboot.ex.springbootex14test.SpringbootEx14TestApplication;
import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex14test.repository.PersonRepository;
import dk.lundogbendsen.springboot.ex.springbootex14test.service.MyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

// Full Spring Context
//@SpringBootTest
//@AutoConfigureMockMvc

// Sliced SpringContext
@WebMvcTest({PersonController.class, MyService.class})
@ContextConfiguration(classes = SpringbootEx14TestApplication.class)
public class PersonControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonRepository personRepository;

    @Before
    public void init() {
        Person person = new Person();
        person.setName("Christian");
        person.setId(1L);
        given(personRepository.getOne(1L)).willReturn(person);
    }

    @Test
    public void exampleTest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/1").contentType(MediaType.APPLICATION_JSON);
        ResultActions perform = mvc.perform(requestBuilder);
        perform
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasKey("id")))
                .andExpect(jsonPath("$", hasKey("name")))
                .andExpect(jsonPath("$.name", is("Christian")));
    }

}
