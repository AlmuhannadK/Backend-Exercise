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

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,
                                      TodoItemRepository toDoItemRepository,
                                      TodoListRepository todoListRepository) {
        return args -> {
            // mock data
            User user1 = new User("alice124", "passwod1", "alice@exmaple.com");
            User user2 = new User("bob456", "password2", "bob@example.com" );
            User user3 = new User("charlie789", "password3", "charlie@example.com");
            User user4 = new User("david101", "password4", "david@example.com");
            User user5 = new User("eve202", "password5", "eve@example.com");
            userRepository.saveAll(List.of(user1,user2,user3,user4,user5));
        };

    }

}
