package com.bilgeadam.personnelmanagementsystem.controller;

import com.bilgeadam.personnelmanagementsystem.dto.PersonnelDTO;
import com.bilgeadam.personnelmanagementsystem.dto.RankDTO;
import com.bilgeadam.personnelmanagementsystem.model.Personnel;
import com.bilgeadam.personnelmanagementsystem.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personnel")
public class PersonnelController {

    @Autowired
    PersonnelService personnelService;

    @PostMapping
    public ResponseEntity<Personnel> createPersonnel(@RequestBody PersonnelDTO req){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(personnelService.createPersonnel(req));
    }
}
