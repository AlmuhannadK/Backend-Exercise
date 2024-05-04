package com.task.backendtask.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.task.backendtask.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "todo_items")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "must not be blank")
    @Size(min = 3, max = 50)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @Column
    @NotNull(message = "due date cannot be null")
    private LocalDate dueDate;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt = Instant.now();


    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    @JsonBackReference
    private TodoList todoList;


}

