package com.example.exampractice.Dto;

import com.example.exampractice.model.Rider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {

    private String teamName;


    @JsonManagedReference
    private List<Rider> riderList;
}
