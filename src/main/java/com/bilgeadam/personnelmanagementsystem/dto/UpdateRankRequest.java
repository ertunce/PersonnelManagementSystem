package com.bilgeadam.personnelmanagementsystem.dto;

import lombok.Data;

@Data
public class UpdateRankRequest {
    private Long id;
    private String name;
    private Double payScale;
}
