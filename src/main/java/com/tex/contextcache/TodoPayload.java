package com.tex.contextcache;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoPayload {
    Integer id;
    String title;
    String quote;

    public static TodoPayload from(Todo todo) {
        return TodoPayload.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .quote(todo.getQuote())
                .build();
    }

    public Todo toTodo() {
        Todo task = new Todo();
        task.setId(id);
        task.setTitle(title);
        task.setQuote(quote);
        return task;
    }
}
