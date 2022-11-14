package com.example.exampractice.service;

import com.example.exampractice.Dto.RiderDto;
import com.example.exampractice.Dto.RiderMapper;
import com.example.exampractice.model.Rider;
import com.example.exampractice.repository.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        rider.setAge(newRider.getAge());
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

    public List<RiderDto> bestFivePeople(){
        List<RiderDto> allRiders = findAllRiders();
        return allRiders.stream()
                .sorted(Comparator.comparing(RiderDto::getFinalTime).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<RiderDto> allSortedAfterTime(){
        List<RiderDto> allRiders = findAllRiders();
        return allRiders.stream()
                .sorted(Comparator.comparing(RiderDto::getFinalTime).reversed())
                .collect(Collectors.toList());
    }
    public Optional<RiderDto> yellowShirt(){
        return findAllRiders().stream()
                .max(Comparator.comparing(RiderDto::getFinalTime));
    }

    public Optional<RiderDto> mountainShirt(){
        return findAllRiders().stream()
                .max(Comparator.comparing(RiderDto::getMountainPoint));
    }

    public Optional<RiderDto> sprintShirt(){
        return findAllRiders().stream()
                .max(Comparator.comparing(RiderDto::getSprintPoint));
    }

    public List<RiderDto> whiteShirt(){
        List<RiderDto> allRiders = findAllRiders();
        return allRiders.stream()
                .filter(riderDto -> riderDto.getAge() < 26)
                .sorted(Comparator.comparing(RiderDto::getFinalTime).reversed())
                .collect(Collectors.toList());
    }


}
