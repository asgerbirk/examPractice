package com.example.exampractice.Dto;

import com.example.exampractice.model.Rider;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Data
public class RiderMapper {
    private final ModelMapper modelMapper;

    public RiderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RiderDto riderToDto(Rider rider){
        return modelMapper.map(rider,RiderDto.class);
    }

    public Rider dtoToRider(RiderDto riderDto){
        return modelMapper.map(riderDto, Rider.class);
    }
}
