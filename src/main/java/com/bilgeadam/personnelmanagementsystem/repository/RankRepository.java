package com.bilgeadam.personnelmanagementsystem.repository;

import com.bilgeadam.personnelmanagementsystem.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Optional<Rank> findRankByName(String name);
    void deleteRankByName(String name);

    @Query("SELECT r FROM Rank r WHERE r.payScale > :payScale")
    List<Rank> findRankNamesByPayScaleGreaterThan(Double payScale);
}
