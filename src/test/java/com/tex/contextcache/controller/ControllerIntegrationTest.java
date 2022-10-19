package com.tex.contextcache.controller;

import com.tex.contextcache.service.TasksService;
import com.tex.contextcache.service.TodoService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@TestPropertySource(properties = {"todo.quote=zoobar"})
public class ControllerIntegrationTest {

    @MockBean
    protected TodoService todoService;

    @MockBean
    protected TasksService tasksService;
}
