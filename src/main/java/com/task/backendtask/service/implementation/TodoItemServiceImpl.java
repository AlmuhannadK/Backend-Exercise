package com.task.backendtask.service.implementation;

import com.task.backendtask.dto.StatusUpdateDTO;
import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.entity.enums.Status;
import com.task.backendtask.repository.TodoItemRepository;
import com.task.backendtask.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }


    @Override
    public Optional<TodoItem> getTodoItemById(Long todoItemId) {
        return todoItemRepository.findById(todoItemId);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        if (todoItem.getDueDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("due date cannot be before current date");
        }
        return todoItemRepository.save(todoItem);
    }

    // TODO: add better exception handling later
    @Override
    public TodoItem updateTodoItemStatus(Long todoItemId, StatusUpdateDTO status) {
        Optional<TodoItem> optionalTodoItem = Optional.ofNullable(todoItemRepository.findById(todoItemId).orElseThrow(() -> new NoSuchElementException()));
        TodoItem todoItem = optionalTodoItem.get();
        todoItem.setStatus(status.getStatus());
        return todoItemRepository.save(todoItem);
    }

}
