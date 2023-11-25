package com.bilgeadam.personnelmanagementsystem.controller;

import com.bilgeadam.personnelmanagementsystem.dto.RankDTO;
import com.bilgeadam.personnelmanagementsystem.dto.RankWithoutPayScaleResponse;
import com.bilgeadam.personnelmanagementsystem.dto.UpdateRankRequest;
import com.bilgeadam.personnelmanagementsystem.model.Rank;
import com.bilgeadam.personnelmanagementsystem.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/all")
    public ResponseEntity<List<RankDTO>> getAllRanks(){
        List<RankDTO> list = rankService.getAllRanks();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/name/by-pay-scale-greater-than/{payScale}")
    public ResponseEntity<List<RankWithoutPayScaleResponse>> getRankNamesByPayScaleGreaterThan(@PathVariable Double payScale){
        List<RankWithoutPayScaleResponse> list = rankService.getRankNamesByPayScaleGreaterThan(payScale);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<RankDTO> getRankByName(@PathVariable String name){
        RankDTO rankDTO = rankService.getRankByName(name);
        return ResponseEntity.ok().body(rankDTO);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<RankDTO> getRankById(@PathVariable Long id){
        RankDTO rankDTO = rankService.getRankById(id);
        return ResponseEntity.ok().body(rankDTO);
    }

    @PostMapping
    public ResponseEntity<RankDTO> createRank(@Validated @RequestBody RankDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(rankService.createRank(request));
    }

    @PutMapping
    public ResponseEntity<RankDTO> updateRank(@Validated @RequestBody UpdateRankRequest req){
        return ResponseEntity.status(HttpStatus.CREATED).body(rankService.updateRank(req));
    }

    @DeleteMapping("/by-id/{id}")
    public ResponseEntity<?> deleteRankById(@PathVariable Long id){
        try{
            rankService.deleteRankById(id);
        }catch (Exception exp){
            exp.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<?> deleteRankByName(@PathVariable(name = "name") String rankName){
        try{
            rankService.deleteRankByName(rankName);
        }catch (Exception exp){
            exp.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/by-rank")
    public ResponseEntity<?> deleteRankByName(@RequestBody Rank rank){
        try{
            rankService.deleteRank(rank);
        }catch (Exception exp){
            exp.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

}













