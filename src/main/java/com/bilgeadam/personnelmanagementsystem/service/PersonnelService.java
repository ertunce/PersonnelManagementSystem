package com.bilgeadam.personnelmanagementsystem.service;

import com.bilgeadam.personnelmanagementsystem.dto.PersonnelDTO;
import com.bilgeadam.personnelmanagementsystem.mapper.RankMapper;
import com.bilgeadam.personnelmanagementsystem.model.Personnel;
import com.bilgeadam.personnelmanagementsystem.model.PersonnelRank;
import com.bilgeadam.personnelmanagementsystem.model.Rank;
import com.bilgeadam.personnelmanagementsystem.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {

    @Autowired
    PersonnelRepository personnelRepository;

    @Autowired
    RankService rankService;

    public Personnel getPersonnelById(Long id){
        return personnelRepository.findById(id).get();
    }

    public Personnel createPersonnel(PersonnelDTO personnelRequest){

        List<PersonnelRank> ranks = personnelRequest.getRanks().stream().map((personnelRankDTO) -> {

                Personnel personnel = getPersonnelById(personnelRankDTO.getPersonnelId());

                Rank rank = RankMapper.INSTANCE.rankDTOToRank(rankService
                        .getRankById(personnelRankDTO.getRankId()));

                PersonnelRank personnelRank = new PersonnelRank();
                personnelRank.setPersonnel(personnel);
                personnelRank.setRank(rank);
                personnelRank.setEndDate(personnelRankDTO.getEndDate());
                personnelRank.setStartDate(personnelRankDTO.getStartDate());
                personnelRank.setIsActive(personnelRankDTO.getIsActive());

                return personnelRank;
        }).toList();

        Personnel personnel = new Personnel(null,
                personnelRequest.getName(),
                personnelRequest.getSurname(),
                personnelRequest.getDateOfBirth(),
                null,
                ranks);

        return personnelRepository.save(personnel);

    }
}
