package com.task.backendtask.controller;

import com.task.backendtask.dto.StatusUpdateDTO;
import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.service.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todo-items")
@Validated
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        List<TodoItem> todoItems = todoItemService.getAllTodoItems();
        return ResponseEntity.ok(todoItems);
    }


    @PostMapping("/{todoListId}/items")
    public ResponseEntity<TodoItem> createTodoItem(@PathVariable Long todoListId ,@Valid @RequestBody TodoItem todoItem) {
        TodoItem createdTodoItem = todoItemService.createTodoItem(todoListId, todoItem);
        return ResponseEntity.ok(createdTodoItem);
    }

    @PostMapping("/{todoItemId}/status")
    public ResponseEntity<TodoItem> updateTodoItemStatus(@PathVariable Long todoItemId, @Valid @RequestBody StatusUpdateDTO status) {
            TodoItem todoItem = todoItemService.updateTodoItemStatus(todoItemId, status);
            return ResponseEntity.ok(todoItem);
    }

}
