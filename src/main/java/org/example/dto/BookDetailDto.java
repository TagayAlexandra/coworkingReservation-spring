package org.example.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.example.entity.WorkSpace;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookDetailDto {

    @NotNull(message = "ID is required, cannot be empty", groups = OnUpdate.class)
    @Positive(message = "ID must be a positive number")
    private Long id;

    @NotNull(message = "Data is required, cannot be empty", groups = {OnCreate.class, OnUpdate.class})
    @Future(message = "Data should be in the future")
    private LocalDate date;

    @NotNull(message = "Start time  is required, cannot be empty", groups = {OnCreate.class, OnUpdate.class})
    private LocalTime startTime;

    @NotNull(message = "End time is required, cannot be empty", groups = {OnCreate.class, OnUpdate.class})
    private LocalTime endTime;

    @NotNull
    private WorkSpace workSpace;


}
