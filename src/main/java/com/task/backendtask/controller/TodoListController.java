package com.task.backendtask.controller;

import com.task.backendtask.entity.TodoList;
import com.task.backendtask.service.TodoListService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/todo-lists")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodoLists() {
        return ResponseEntity.ok(todoListService.getAllTodoLists());
    }

    @GetMapping(path = "/admin/{todoListId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable @Min(1) Long todoListId) {
        TodoList todoList = todoListService.getTodoListById(todoListId);
        return ResponseEntity.ok(todoList);
    }


    @GetMapping(path = "/search")
    public ResponseEntity<TodoList> getTodoListByTitle(@RequestParam String listTitle) {
        TodoList todoList = todoListService.getTodoListByTitle(listTitle);
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
    public ResponseEntity<TodoList> createTodoList(@Valid @RequestBody TodoList todoList) {
        return ResponseEntity.ok(todoListService.createTodoList(todoList));
    }
}
