package com.tex.contextcache.controller.todo;

import com.tex.contextcache.Todo;
import com.tex.contextcache.TodoPayload;
import com.tex.contextcache.dao.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class TodosGetController {

    private final TodoRepository todoRepository;

    @GetMapping("todos")
    public ResponseEntity<List<TodoPayload>> todos() {
        return ok(todoRepository.findAll().stream().map(TodoPayload::from).toList());
    }
}
