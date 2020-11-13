package dk.lundogbendsen.springboot.ex.springbootex14test.api;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex14test.repository.PersonRepository;
import dk.lundogbendsen.springboot.ex.springbootex14test.service.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// SpringRunner loads the Spring ApplicationContext which in turn make the Dependency Injection
@ExtendWith(SpringExtension.class)

// Sliced SpringContext
// Register the classes in the list as SpringBean
@WebMvcTest({PersonController.class, MyService.class})
public class PersonControllerSlicedSpringRunnerFakeHttp {

    @Autowired
    private MockMvc mvc;

    // Register a Mocked bean in the place of this type. This Mock will be Dependency Injected into the other Spring Beans
    @MockBean
    private PersonRepository personRepository;

    @BeforeEach
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
