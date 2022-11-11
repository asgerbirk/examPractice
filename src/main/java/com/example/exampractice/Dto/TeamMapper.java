package com.example.exampractice.Dto;

import com.example.exampractice.model.Rider;
import com.example.exampractice.model.Team;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    private final ModelMapper modelMapper;

    public TeamMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public TeamDto teamToDto(Team team){
        return modelMapper.map(team,TeamDto.class);
    }

    public Team dtoToTeam(TeamDto teamDto){
        return modelMapper.map(teamDto, Team.class);
    }
}
