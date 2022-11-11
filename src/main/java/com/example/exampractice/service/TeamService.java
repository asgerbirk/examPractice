package com.example.exampractice.service;

import com.example.exampractice.Dto.TeamDto;
import com.example.exampractice.Dto.TeamMapper;
import com.example.exampractice.model.Team;
import com.example.exampractice.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final RiderService riderService;

    public TeamService(TeamRepository teamRepository, TeamMapper teamMapper, RiderService riderService) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.riderService = riderService;
    }

    public List<TeamDto> findAllTeams(){
        return teamRepository.findAll().stream().map(teamMapper::teamToDto).collect(Collectors.toList());
    }

    public TeamDto findTeamById(Long id){
        Team team = teamRepository.findById(id).orElseThrow(()-> new IllegalStateException("not found with taht" + id));
        return teamMapper.teamToDto(team);
    }



}
