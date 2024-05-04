package com.task.backendtask.service;

import com.task.backendtask.entity.TodoList;

import java.util.List;

public interface TodoListService {

    public TodoList getTodoListById(Long todoListId);

    public TodoList getTodoListByTitle(String listTitle);

    public List<TodoList> getAllTodoLists();

    public TodoList createTodoList(TodoList todoList);
}