package com.example.exampractice.controller;

import com.example.exampractice.Dto.RiderDto;
import com.example.exampractice.Dto.TeamDto;
import com.example.exampractice.model.Rider;
import com.example.exampractice.model.Team;
import com.example.exampractice.service.RiderService;
import com.example.exampractice.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/riders")
public class RiderController {

    private final RiderService riderService;
    private final TeamService teamService;

    public RiderController(RiderService riderService, TeamService teamService) {
        this.riderService = riderService;
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<RiderDto>> getAllRiders(){
        return ResponseEntity.ok().body(riderService.findAllRiders());
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        return ResponseEntity.ok().body(teamService.findAllTeams());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RiderDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(riderService.findRiderById(id));
    }

    @GetMapping("/sortFive")
    public ResponseEntity<List<RiderDto>> bestFinalTime(){
        return ResponseEntity.ok().body(riderService.bestFivePeople());
    }

    @GetMapping("/allSorted")
    public ResponseEntity<List<RiderDto>> sortedAfterTime(){
        return ResponseEntity.ok().body(riderService.allSortedAfterTime());
    }

    @GetMapping("/yellow")
    public ResponseEntity<Optional<RiderDto>> riderWithYellowShirt(){
        return ResponseEntity.ok().body(riderService.yellowShirt());
    }

    @GetMapping("/sprintShirt")
    public ResponseEntity<Optional<RiderDto>> riderWithSprintShirt(){
        return ResponseEntity.ok().body(riderService.sprintShirt());
    }

    @GetMapping("/mountainShirt")
    public ResponseEntity<Optional<RiderDto>> riderWithMountainShirt(){
        return ResponseEntity.ok().body(riderService.mountainShirt());
    }

    @GetMapping("/whiteShirt")
    public ResponseEntity<List<RiderDto>> theWhiteShirt(){
        return ResponseEntity.ok().body(riderService.whiteShirt());
    }


    @PostMapping
    public ResponseEntity<Rider> createRider(@Valid @RequestBody Rider rider){

        return ResponseEntity.ok().body(riderService.createRider(rider));
    }

    @PutMapping ("/{id}")
    ResponseEntity<RiderDto> update(@PathVariable Long id, @Valid @RequestBody RiderDto riderDto){
        return ResponseEntity.ok().body(riderService.updateRider(id,riderDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRider(@PathVariable("id") Long id){
        riderService.deleteRider(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
