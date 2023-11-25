package com.bilgeadam.personnelmanagementsystem.mapper;

import com.bilgeadam.personnelmanagementsystem.dto.RankDTO;
import com.bilgeadam.personnelmanagementsystem.model.Rank;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-24T13:34:24+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class RankMapperImpl implements RankMapper {

    @Override
    public RankDTO rankToRankDTO(Rank rank) {
        if ( rank == null ) {
            return null;
        }

        RankDTO rankDTO = new RankDTO();

        rankDTO.setName( rank.getName() );
        rankDTO.setPayScale( rank.getPayScale() );

        return rankDTO;
    }

    @Override
    public Rank rankDTOToRank(RankDTO rankDTO) {
        if ( rankDTO == null ) {
            return null;
        }

        Rank rank = new Rank();

        rank.setName( rankDTO.getName() );
        rank.setPayScale( rankDTO.getPayScale() );

        return rank;
    }
}
