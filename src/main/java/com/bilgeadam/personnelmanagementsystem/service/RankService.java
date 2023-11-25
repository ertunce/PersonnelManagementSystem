package com.bilgeadam.personnelmanagementsystem.service;

import com.bilgeadam.personnelmanagementsystem.dto.RankDTO;
import com.bilgeadam.personnelmanagementsystem.dto.RankWithoutPayScaleResponse;
import com.bilgeadam.personnelmanagementsystem.dto.UpdateRankRequest;
import com.bilgeadam.personnelmanagementsystem.mapper.RankMapper;
import com.bilgeadam.personnelmanagementsystem.model.Rank;
import com.bilgeadam.personnelmanagementsystem.repository.RankRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RankService {

    @Autowired
    private RankRepository rankRepository;

    public List<RankDTO> getAllRanks(){
        List<Rank> rankList = rankRepository.findAll();

        List<RankDTO> rankResponseList = new ArrayList<RankDTO>();

        for(Rank rank : rankList){
            RankDTO rankDTO = RankMapper.INSTANCE.rankToRankDTO(rank);
            rankResponseList.add(rankDTO);
        }

        return rankResponseList;
    }

    public List<RankWithoutPayScaleResponse> getRankNamesByPayScaleGreaterThan(Double payScale){
        List<Rank> rankList = rankRepository.findRankNamesByPayScaleGreaterThan(payScale);

        List<RankWithoutPayScaleResponse> rankResponseList = new ArrayList<RankWithoutPayScaleResponse>();

        for(Rank rank : rankList){
            RankWithoutPayScaleResponse response = new RankWithoutPayScaleResponse();
            response.setName(rank.getName());

            rankResponseList.add(response);
        }

        return rankResponseList;
    }

    public RankDTO getRankById(Long id){
        Rank rank = rankRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Rank not found"));

        return RankMapper.INSTANCE.rankToRankDTO(rank);
    }

    public RankDTO getRankByName(String rankName){
        Rank rank = rankRepository.findRankByName(rankName).orElseThrow(()
                -> new RuntimeException("Rank not found"));


        return RankMapper.INSTANCE.rankToRankDTO(rank);
    }

    public RankDTO createRank(RankDTO request){
        Rank rank = RankMapper.INSTANCE.rankDTOToRank(request);
        Rank persistedRank = rankRepository.save(rank);
        RankDTO response = RankMapper.INSTANCE.rankToRankDTO(persistedRank);

        return response;
    }

    public RankDTO updateRank(UpdateRankRequest request){
        Rank rank = rankRepository.findById(request.getId()).orElseThrow(()
                -> new RuntimeException("Rank not found"));

        Optional.ofNullable(request.getName()).ifPresent((name)
                -> rank.setName(name));

        Optional.ofNullable(request.getPayScale()).ifPresent((payScale)
                -> rank.setPayScale(payScale));

        Rank updatedRank = rankRepository.save(rank);
        return RankMapper.INSTANCE.rankToRankDTO(updatedRank);
    }

    public void deleteRankById(Long id){
        rankRepository.deleteById(id);
    }

    public void deleteRank(Rank rank){
        rankRepository.delete(rank);
    }

    @Transactional
    public void deleteRankByName(String rankName){
        rankRepository.deleteRankByName(rankName);
    }
}
