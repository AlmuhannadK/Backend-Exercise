package com.task.backendtask.service.implementation;

import com.task.backendtask.entity.TodoList;
import com.task.backendtask.repository.TodoListRepository;
import com.task.backendtask.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListServiceImpl implements TodoListService {


    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }


    @Override
    public TodoList getTodoListById(Long todoListId) {
        Optional<TodoList> optional = todoListRepository.findById(todoListId);
        if (optional.isPresent()) {
            TodoList todoList =  optional.get();
            return todoList;
        }
        // throw exception?
        // TODO: handle this null later
        return null;
    }

    @Override
    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoList createTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }
}
