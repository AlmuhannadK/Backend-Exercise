package com.task.backendtask.service;

import com.task.backendtask.dto.StatusUpdateDTO;
import com.task.backendtask.entity.TodoItem;



import java.util.List;
import java.util.Optional;

public interface TodoItemService {

    public Optional<TodoItem> getTodoItemById(Long todoItemId);

    public List<TodoItem> getAllTodoItems();

    public TodoItem createTodoItem(TodoItem todoItem);

    public TodoItem updateTodoItemStatus(Long todoItemId, StatusUpdateDTO status);
}
