package com.task.backendtask.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String error;
    private String message;
    private int status;
    private LocalDateTime timestamp;

}
