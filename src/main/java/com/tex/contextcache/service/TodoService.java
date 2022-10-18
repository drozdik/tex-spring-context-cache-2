package com.tex.contextcache.service;

import com.tex.contextcache.Todo;
import com.tex.contextcache.dao.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> allTodos() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        if (todo.getId() == null) {
            return todoRepository.save(todo);
        }
        Todo persisted = todoRepository.findById(todo.getId()).orElseThrow(() -> new RuntimeException("Todo id %s not found".formatted(todo.getId())));
        if (todo.getTitle() != null) {
            persisted.setTitle(todo.getTitle());
        }
        if (todo.getQuote() != null) {
            persisted.setQuote(todo.getQuote());
        }
        return todoRepository.save(persisted);
    }

}
