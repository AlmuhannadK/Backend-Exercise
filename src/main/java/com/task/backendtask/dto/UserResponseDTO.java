package com.task.backendtask.dto;


import com.task.backendtask.entity.TodoList;
import com.task.backendtask.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String username;


    private Role role;


    private List<TodoList> todoLists;
}
