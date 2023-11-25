package com.bilgeadam.personnelmanagementsystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonnelRankDTO {
    private Long id;
    private Long personnelId;
    private Long rankId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}
