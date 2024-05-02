package com.task.backendtask.service;

import com.task.backendtask.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);

}
