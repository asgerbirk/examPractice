package com.example.exampractice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double finalTime;

    private int mountainPoint;

    private double sprintPoint;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;

    public Rider(String name, double finalTime, int mountainPoint, double sprintPoint, Team team) {
        this.name = name;
        this.finalTime = finalTime;
        this.mountainPoint = mountainPoint;
        this.sprintPoint = sprintPoint;
        this.team = team;
    }
}
