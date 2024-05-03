package com.task.backendtask.dto;

import com.task.backendtask.entity.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusUpdateDTO {

    @NotNull
    private Status status;
}
