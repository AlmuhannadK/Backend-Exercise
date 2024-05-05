package com.task.backendtask.service.implementation;

import com.task.backendtask.entity.TodoList;
import com.task.backendtask.entity.User;
import com.task.backendtask.repository.TodoListRepository;
import com.task.backendtask.repository.UserRepository;
import com.task.backendtask.service.TodoListService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoListServiceImpl implements TodoListService {


    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository, UserRepository userRepository) {
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }


    @Override
    public TodoList getTodoListById(Long todoListId) {
        return todoListRepository.findById(todoListId)
                .orElseThrow(() -> new NoSuchElementException("List not found"));
    }

    @Override
    public TodoList getTodoListByTitle(String listTitle) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        return todoListRepository.findTodoListByTitleIgnoreCaseAndUserId(listTitle, user.getId())
                .orElseThrow(() -> new NoSuchElementException("List not found"));
    }

    @Override
    public List<TodoList> getAllTodoLists() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return todoListRepository.findByUserId(user.getId());
    }

    @Override
    @Transactional
    public TodoList createTodoList(TodoList todoList) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        todoList.setUser(user);
        return todoListRepository.save(todoList);
    }
}
