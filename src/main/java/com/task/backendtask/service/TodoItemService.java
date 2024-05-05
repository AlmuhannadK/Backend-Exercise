package com.task.backendtask.service;

import com.task.backendtask.dto.StatusUpdateDTO;
import com.task.backendtask.entity.TodoItem;



import java.util.List;

public interface TodoItemService {

     TodoItem getTodoItemById(Long todoItemId);
     List<TodoItem> getAllTodoItems();
     TodoItem createTodoItem(Long todoListId, TodoItem todoItem);
     TodoItem updateTodoItemStatus(Long todoItemId, StatusUpdateDTO status);
}
