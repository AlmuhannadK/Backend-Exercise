package com.task.backendtask.controller;

import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.entity.enums.Status;
import com.task.backendtask.repository.TodoItemRepository;
import com.task.backendtask.service.TodoItemService;
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
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }
    // Get all todoItems (admin)
    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        List<TodoItem> todoItems = todoItemService.getAllTodoItems();
        if (todoItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todoItems);
    }

    // Get todoItem by id (user)
    @GetMapping(path = "/{todoItemId}")
    public ResponseEntity<Optional<TodoItem>> getTodoItem(@PathVariable @Min(1) Long todoItemId) {
        Optional<TodoItem> todoItem = todoItemService.getTodoItem(todoItemId);
        if (todoItem.isPresent()) {
            return ResponseEntity.ok(todoItem);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<TodoItem> createTodoItem(@Valid @RequestBody TodoItem todoItem) {
        TodoItem createdTodoItem = todoItemService.createTodoItem(todoItem);
        return ResponseEntity.ok(createdTodoItem);
    }

    @PostMapping("/{todoItemId}/status")
    public ResponseEntity<TodoItem> updateTodoItemStatus(@PathVariable Long todoItemId, @RequestBody Status status) {
        try {
            TodoItem todoItem = todoItemService.updateTodoItemStatus(todoItemId, status);
            return ResponseEntity.ok(todoItem);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    }