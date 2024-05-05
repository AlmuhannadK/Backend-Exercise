package com.task.backendtask.service.implementation;

import com.task.backendtask.dto.StatusUpdateDTO;
import com.task.backendtask.entity.TodoItem;
import com.task.backendtask.entity.TodoList;
import com.task.backendtask.entity.User;
import com.task.backendtask.repository.TodoItemRepository;
import com.task.backendtask.repository.TodoListRepository;
import com.task.backendtask.repository.UserRepository;
import com.task.backendtask.service.TodoItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;
    private final UserRepository userRepository;
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository, UserRepository userRepository, TodoListRepository todoListRepository) {
        this.todoItemRepository = todoItemRepository;
        this.userRepository = userRepository;
        this.todoListRepository = todoListRepository;
    }


    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    @Transactional
    public TodoItem createTodoItem(Long todoListId, TodoItem todoItem) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        TodoList todoList = todoListRepository.findById(todoListId)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));

        if (user.getTodoLists() == null || user.getTodoLists().isEmpty()) {
            TodoList newTodoList = new TodoList();
            user.addTodoList(newTodoList);
            newTodoList.setUser(user);
            newTodoList.addTodoItem(todoItem);
            todoListRepository.save(todoList);
        }

        todoList.addTodoItem(todoItem);
        return todoItemRepository.save(todoItem);
    }


    @Override
    public TodoItem updateTodoItemStatus(Long todoItemId, StatusUpdateDTO status) {
        TodoItem todoItem = todoItemRepository.findById(todoItemId)
                .orElseThrow(() -> new NoSuchElementException("item does not exist"));
        todoItem.setStatus(status.getStatus());
        return todoItemRepository.save(todoItem);
    }

}
