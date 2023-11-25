package com.bilgeadam.personnelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PersonnelRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;

    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}
