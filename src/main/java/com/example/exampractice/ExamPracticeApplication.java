package com.example.exampractice;

import com.example.exampractice.model.Rider;
import com.example.exampractice.model.Team;
import com.example.exampractice.repository.RiderRepository;
import com.example.exampractice.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExamPracticeApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(RiderRepository riderRepository, TeamRepository teamRepository){
        return (args -> {
            final List<Rider> riderList = new ArrayList<>();
            final List<Team> teamList = new ArrayList<>();


            teamList.add(new Team("team easy on"));
            teamList.add(new Team("team zando"));
            teamList.add(new Team("team saxo bank"));
            teamList.add(new Team("team john"));
            teamRepository.saveAll(teamList);

            riderList.add(new Rider("zando",20, 1000,12313,442323,teamList.get(0)));
            riderList.add(new Rider("hej",30, 900,12312,44343,teamList.get(1)));
            riderList.add(new Rider("smash",42, 800,1233232,44343,teamList.get(2)));
            riderList.add(new Rider("vr", 19,700,12323,44335,teamList.get(2)));
            riderList.add(new Rider("dw", 50, 600,12323,44335,teamList.get(3)));
            riderList.add(new Rider("dwddwqdq", 50,500,12323,44335,teamList.get(3)));
            riderList.add(new Rider("sazd", 15,400,12323,44335,teamList.get(3)));
            riderList.add(new Rider("xsqsq", 14,300,12323,44335,teamList.get(3)));
            riderList.add(new Rider("dw1d", 10,200,12323,44335,teamList.get(3)));
            riderRepository.saveAll(riderList);

        });
    }


}
