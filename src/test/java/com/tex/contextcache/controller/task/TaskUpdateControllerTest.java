package com.tex.contextcache.controller.task;

import com.tex.contextcache.Task;
import com.tex.contextcache.controller.ControllerIntegrationTest;
import com.tex.contextcache.service.TasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TaskUpdateControllerTest extends ControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void update() throws Exception {
        String payload = """
                {
                "description":"new description"
                }
                """;

        Task forSave = new Task();
        forSave.setDescription("new description");
        forSave.setId(1);

        when(tasksService.saveTask(forSave)).thenReturn(new Task());

        mockMvc.perform(
                        put("/tasks/1")
                                .contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(
                        status().isOk()
                );
    }
}
