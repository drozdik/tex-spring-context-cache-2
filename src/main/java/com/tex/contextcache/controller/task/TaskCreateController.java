package com.tex.contextcache.controller.task;

import com.tex.contextcache.TaskPayload;
import com.tex.contextcache.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class TaskCreateController {
    final TasksService tasksService;

    @PostMapping("tasks")
    public ResponseEntity<TaskPayload> createTask(@RequestBody TaskPayload payload) {
        return ok(TaskPayload.from(tasksService.saveTask(payload.toTask())));
    }
}
