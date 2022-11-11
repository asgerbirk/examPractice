package com.example.exampractice.service;

import com.example.exampractice.Dto.RiderDto;
import com.example.exampractice.Dto.RiderMapper;
import com.example.exampractice.model.Rider;
import com.example.exampractice.model.Team;
import com.example.exampractice.repository.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RiderService {

    private final RiderRepository riderRepository;
    private final RiderMapper riderMapper;

    public RiderService(RiderRepository riderRepository, RiderMapper riderMapper) {
        this.riderRepository = riderRepository;
        this.riderMapper = riderMapper;
    }

    public List<RiderDto> findAllRiders(){
        return riderRepository.findAll().stream().map(riderMapper::riderToDto).collect(Collectors.toList());
    }

    public RiderDto findRiderById(Long id){
        Rider rider = riderRepository.findById(id).orElseThrow(()->new IllegalStateException("no rider with that id" + id));
        return riderMapper.riderToDto(rider);
    }

    public RiderDto createRider(RiderDto riderDto){
        Rider rider = riderMapper.dtoToRider(riderDto);
        return riderMapper.riderToDto(riderRepository.save(rider));
    }

    public RiderDto updateRider(Long id, RiderDto newRider){
        Rider rider = riderRepository.findById(id).orElseThrow(()->new IllegalStateException("no rider with that id" + id));
        rider.setName(newRider.getName());
        rider.setFinalTime(newRider.getFinalTime());
        rider.setMountainPoint(newRider.getMountainPoint());
        rider.setSprintPoint(newRider.getSprintPoint());
        riderRepository.save(rider);
        return riderMapper.riderToDto(rider);

    }

    public void deleteRider(Long id){
        boolean checkIfRiderExists = riderRepository.existsById(id);
        if (!checkIfRiderExists){
            throw new IllegalStateException("does not exists " + id);
        }
        riderRepository.deleteById(id);
    }




}
