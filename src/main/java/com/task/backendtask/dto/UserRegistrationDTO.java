package com.task.backendtask.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {

    private String username;
    @NotNull
    @Size(min = 3, max = 30, message = "password must be between 3 and 30 characters long")
    private String password;
}
