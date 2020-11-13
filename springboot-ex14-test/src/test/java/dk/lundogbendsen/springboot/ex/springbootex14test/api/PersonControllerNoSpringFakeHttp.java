package dk.lundogbendsen.springboot.ex.springbootex14test.api;

import dk.lundogbendsen.springboot.ex.springbootex14test.model.Person;
import dk.lundogbendsen.springboot.ex.springbootex14test.service.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PersonControllerNoSpringFakeHttp {

    private MockMvc mvc;

    @Mock
    private MyService myService;

    @InjectMocks
    private PersonController personController;


    @BeforeEach
    public void setup() {
        // MockMvc standalone approach
        mvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @BeforeEach
    public void init() {
        Person person = new Person();
        person.setName("Christian");
        person.setId(1L);
        given(myService.get(1L)).willReturn(person);
    }

    @Test
    public void exampleTest() throws Exception {
        mvc.perform(get("/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasKey("id")))
                .andExpect(jsonPath("$", hasKey("name")))
                .andExpect(jsonPath("$.name", is("Christian")));
    }

}
