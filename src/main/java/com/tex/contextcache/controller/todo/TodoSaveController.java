package com.tex.contextcache.controller.todo;

import com.tex.contextcache.TodoPayload;
import com.tex.contextcache.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoSaveController {

    final TodoService todoService;

    @Value("${todo.quote}")
    private String defaultQuote;


    @PostMapping("todo")
    public ResponseEntity<TodoPayload> save(@RequestBody TodoPayload payload) {
        if (payload.getQuote() == null) {
            payload.setQuote(defaultQuote);
        }
        return ResponseEntity.ok(TodoPayload.from(todoService.saveTodo(payload.toTodo())));
    }


}
