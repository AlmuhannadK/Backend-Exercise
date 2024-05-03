package com.task.backendtask.service;

import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.entity.enums.Status;



import java.util.List;
import java.util.Optional;

public interface TodoItemService {

    public Optional<TodoItem> getTodoItem(Long todoItemId);

    public List<TodoItem> getAllTodoItems();

    public TodoItem createTodoItem(TodoItem todoItem);

    public TodoItem updateTodoItemStatus(Long todoItemId, Status status);
}