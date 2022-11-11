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

            riderList.add(new Rider("zando", 15.5,12313,442323,teamList.get(0)));
            riderList.add(new Rider("hej", 1345,12312,44343,teamList.get(1)));
            riderList.add(new Rider("smash", 15343.5,1233232,44343,teamList.get(2)));
            riderList.add(new Rider("vr", 15.3215,12323,44335,teamList.get(2)));
            riderList.add(new Rider("dw", 15.3215,12323,44335,teamList.get(3)));
            riderList.add(new Rider("dwddwqdq", 15.3215,12323,44335,teamList.get(3)));
            riderList.add(new Rider("sazd", 15.3215,12323,44335,teamList.get(3)));
            riderList.add(new Rider("xsqsq", 15.3215,12323,44335,teamList.get(3)));
            riderList.add(new Rider("dw1d", 15.3215,12323,44335,teamList.get(3)));
            riderRepository.saveAll(riderList);

        });
    }


}
