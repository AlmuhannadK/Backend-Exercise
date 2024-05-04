package com.task.backendtask.service;

import com.task.backendtask.entity.TodoList;

import java.util.List;

public interface TodoListService {

     TodoList getTodoListById(Long todoListId);
     TodoList getTodoListByTitle(String listTitle);
     List<TodoList> getAllTodoLists();
     TodoList createTodoList(TodoList todoList);
}
