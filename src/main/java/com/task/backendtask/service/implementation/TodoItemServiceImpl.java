package com.task.backendtask.service.implementation;

import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.repository.TodoItemRepository;
import com.task.backendtask.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public Optional<TodoItem> getTodoItem(Long todoItemId) {
        return todoItemRepository.findById(todoItemId);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }
}
