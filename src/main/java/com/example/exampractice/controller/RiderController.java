package com.example.exampractice.controller;

import com.example.exampractice.Dto.RiderDto;
import com.example.exampractice.model.Rider;
import com.example.exampractice.service.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/riders")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping
    public ResponseEntity<List<RiderDto>> getAllRiders(){
        return ResponseEntity.ok().body(riderService.findAllRiders());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RiderDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(riderService.findRiderById(id));
    }

    @PostMapping
    public ResponseEntity<RiderDto> createRider(@Valid @RequestBody RiderDto riderDto){
        return ResponseEntity.ok().body(riderService.createRider(riderDto));
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
