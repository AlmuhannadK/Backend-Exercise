package com.task.backendtask.service;

import com.task.backendtask.dto.StatusUpdateDTO;
import com.task.backendtask.entity.TodoItem;



import java.util.List;
import java.util.Optional;

public interface TodoItemService {

     Optional<TodoItem> getTodoItemById(Long todoItemId);
     List<TodoItem> getAllTodoItems();
     TodoItem createTodoItem(TodoItem todoItem);
     TodoItem updateTodoItemStatus(Long todoItemId, StatusUpdateDTO status);
}
