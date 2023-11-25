package com.bilgeadam.personnelmanagementsystem.repository;

import com.bilgeadam.personnelmanagementsystem.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
