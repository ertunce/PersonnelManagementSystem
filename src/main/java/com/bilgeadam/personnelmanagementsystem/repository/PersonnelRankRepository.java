package com.bilgeadam.personnelmanagementsystem.repository;

import com.bilgeadam.personnelmanagementsystem.model.PersonnelRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRankRepository extends JpaRepository<PersonnelRank, Long> {
}
