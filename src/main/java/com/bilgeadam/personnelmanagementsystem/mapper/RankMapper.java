package com.bilgeadam.personnelmanagementsystem.mapper;

import com.bilgeadam.personnelmanagementsystem.dto.RankDTO;
import com.bilgeadam.personnelmanagementsystem.model.Rank;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankMapper {
    RankMapper INSTANCE = Mappers.getMapper(RankMapper.class);

    RankDTO rankToRankDTO(Rank rank);
    Rank rankDTOToRank(RankDTO rankDTO);
}
