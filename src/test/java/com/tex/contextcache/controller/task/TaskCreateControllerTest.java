package com.tex.contextcache.controller.task;

import com.tex.contextcache.Task;
import com.tex.contextcache.service.TasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.tex.contextcache.Task.Status.UNFINISHED;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TaskCreateControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    TasksService tasksService;

    @Test
    void create() throws Exception {
        String payload = """
                {
                "description":"first task",
                "status":"UNFINISHED"
                }
                """;

        Task forSave = new Task();
        forSave.setDescription("first task");
        forSave.setStatus(UNFINISHED);
        when(tasksService.saveTask(forSave)).thenReturn(new Task());

        mockMvc.perform(
                post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(
                        status().isOk()
                );
    }
}
