package com.example.exampractice.repository;

import com.example.exampractice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

}
