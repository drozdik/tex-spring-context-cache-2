package com.tex.contextcache.controller.todo;

import com.tex.contextcache.Todo;
import com.tex.contextcache.controller.ControllerIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TodoCreateControllerTest extends ControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void save() throws Exception {
        String payload = """
                {
                "title":"some title",
                "quote":"some quote"
                }
                """;

        Todo forSave = new Todo();
        forSave.setTitle("some title");
        forSave.setQuote("some quote");
        when(todoService.saveTodo(forSave)).thenReturn(new Todo());

        mockMvc.perform(
                        post("/todo")
                                .contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(
                        status().isOk()
                );
    }
}
