package com.task.backendtask;

import com.task.backendtask.entity.User;
import com.task.backendtask.repository.TodoItemRepository;
import com.task.backendtask.repository.TodoListRepository;
import com.task.backendtask.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BackendTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendTaskApplication.class, args);
    }

}
