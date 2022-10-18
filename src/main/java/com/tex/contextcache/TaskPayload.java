package com.tex.contextcache;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskPayload {
    Integer id;
    String description;
    Task.Status status;

    public static TaskPayload from(Task task) {
        return TaskPayload.builder()
                .id(task.getId())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }

    public Task toTask() {
        Task task = new Task();
        task.setId(id);
        task.setDescription(description);
        task.setStatus(status);
        return task;
    }
}
