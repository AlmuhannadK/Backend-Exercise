package com.task.backendtask.service;

import com.task.backendtask.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User createUser(User user);
    public List<User> getAllUsers();
    public Optional<User> getUserById(Long userId);
    public User getUserByUsername(String username);

}
