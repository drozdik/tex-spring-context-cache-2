package com.tex.contextcache.controller;

import com.tex.contextcache.TaskPayload;
import com.tex.contextcache.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class TaskUpdateController {
    final TasksService tasksService;

    @PutMapping("tasks/{taskId}")
    public ResponseEntity<TaskPayload> updateTask(
            @PathVariable Integer taskId,
            @RequestBody TaskPayload payload) {
        payload.setId(taskId);
        return ok(TaskPayload.from(tasksService.saveTask(payload.toTask())));
    }
}
