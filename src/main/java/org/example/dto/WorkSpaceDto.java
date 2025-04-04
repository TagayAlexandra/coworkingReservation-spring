package org.example.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorkSpaceDto {


    private Long id;


    private String typeSpace;


    private BigDecimal price;


    private boolean available;

}
