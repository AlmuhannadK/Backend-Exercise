package com.task.backendtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Size(min = 3, max = 20, message = "username must be between 3 and 20 characters")
    private String username;

    @Column
    @NotNull
    @Size(min = 8, max = 20, message = "password must be between 8 and 20 characters")
    private String password;

    @Column(unique = true)
    @Email
    @NotNull
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoList> todoLists = new ArrayList<>();

}


