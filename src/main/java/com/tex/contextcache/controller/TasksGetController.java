package com.tex.contextcache.controller;

import com.tex.contextcache.TaskPayload;
import com.tex.contextcache.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class TasksGetController {
    final TasksService tasksService;

    @GetMapping("tasks")
    public ResponseEntity<List<TaskPayload>> getTasks() {
        return ok(tasksService.allTasks().stream().map(TaskPayload::from).toList());
    }
}
