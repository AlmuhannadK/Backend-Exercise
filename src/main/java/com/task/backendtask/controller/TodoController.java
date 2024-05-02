package com.task.backendtask.controller;

import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.repository.ToDoItemRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/todos")
@Validated
public class TodoController {

    @Autowired
    private ToDoItemRepository todoItemRepository;


    // Get all todoItems (admin)
    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        List<TodoItem> todoItems = todoItemRepository.findAll();
        if (todoItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todoItems);
    }

    // Get todoItem by id (user)
    @GetMapping(path = "/{todoId}")
    public ResponseEntity<Optional<TodoItem>> getTodoItem(@PathVariable @Min(1) long todoId) {
        Optional<TodoItem> todoItem = todoItemRepository.findById(todoId);
        if (todoItem.isPresent()) {
            return ResponseEntity.ok(todoItem);
        }
        return ResponseEntity.notFound().build();
    }


    // create a todoItem
    @PostMapping()
    public ResponseEntity<TodoItem> createTodoItem(@Valid @RequestBody TodoItem todoItem) {
        if (todoItem == null) {
            return ResponseEntity.badRequest().build();
        }
        todoItemRepository.save(todoItem);
        return ResponseEntity.ok(todoItem);
    }

    // create a todoList



}
