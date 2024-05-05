package com.task.backendtask.service;

import com.task.backendtask.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    Optional<User> getUserByUsername(String username);

}
