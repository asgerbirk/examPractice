package com.example.exampractice.controller;

import com.example.exampractice.Dto.TeamDto;
import com.example.exampractice.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
      return ResponseEntity.ok().body(teamService.findAllTeams());
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDto> findTeamById(@PathVariable Long id){
        return ResponseEntity.ok().body(teamService.findTeamById(id));
    }
}
