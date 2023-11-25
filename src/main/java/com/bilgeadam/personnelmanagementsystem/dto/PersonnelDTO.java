package com.bilgeadam.personnelmanagementsystem.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonnelDTO {

    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;
    private List<PersonnelRankDTO> ranks;
}
