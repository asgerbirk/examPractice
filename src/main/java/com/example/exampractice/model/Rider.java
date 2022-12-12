package com.example.exampractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

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

    private int age;

    private String country;

    private double finalTime;

    private int mountainPoint;

    private double sprintPoint;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    public Rider(String name, int age,String country, double finalTime, int mountainPoint, double sprintPoint, Team team) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.finalTime = finalTime;
        this.mountainPoint = mountainPoint;
        this.sprintPoint = sprintPoint;
        this.team = team;
    }
}
