package org.example.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WorkSpaceDto {

    @NotBlank(message = "ID is required, cannot be empty", groups = OnUpdate.class)
    @Positive(message = "ID must be a positive number")
    private Long id;

    @NotBlank(message = "TypeSpace is required, cannot be empty", groups = {OnCreate.class, OnUpdate.class})
    private String typeSpace;

    @NotBlank(message = "The price is required, cannot be empty", groups = {OnCreate.class, OnUpdate.class})
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class})
    private boolean available;
}
