package com.example.exampractice.Dto;

import com.example.exampractice.model.Rider;
import com.example.exampractice.model.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor

public class RiderDto {

    private Long id;
    private String name;
    private int age;

    private double finalTime;

    private int mountainPoint;

    private double sprintPoint;

    private Team team;


}
