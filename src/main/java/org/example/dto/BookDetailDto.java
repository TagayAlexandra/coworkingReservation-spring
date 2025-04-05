package org.example.dto;

import lombok.Data;
import org.example.entity.WorkSpace;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookDetailDto {


    private Long id;


    private LocalDate date;

    private LocalTime startTime;


    private LocalTime endTime;


    private WorkSpace workSpace;


}
