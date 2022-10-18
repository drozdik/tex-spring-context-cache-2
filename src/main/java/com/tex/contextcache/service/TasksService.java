package com.tex.contextcache.service;

import com.tex.contextcache.Task;
import com.tex.contextcache.dao.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TaskRepository taskRepository;

    public List<Task> allTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        if (task.getId() == null) {
            return taskRepository.save(task);
        }
        Task persisted = taskRepository.findById(task.getId()).orElseThrow(() -> new RuntimeException("Task id %s not found".formatted(task.getId())));
        if (task.getStatus() != null) {
            persisted.setStatus(task.getStatus());
        }
        if (task.getDescription() != null) {
            persisted.setDescription(task.getDescription());
        }
        return taskRepository.save(persisted);
    }

}
