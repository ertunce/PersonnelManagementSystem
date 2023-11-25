package com.bilgeadam.personnelmanagementsystem.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RankDTO {
    //DTO => Data Transfer Object

    @NotBlank(message = "Rank name cannot be null.")
    private String name;

    @NotNull
    @PositiveOrZero(message = "Salary should be greater than or equals 0")
    @Max(value = 100000, message = "Salary should be smaller than 100.000")
    private Double payScale;
}
