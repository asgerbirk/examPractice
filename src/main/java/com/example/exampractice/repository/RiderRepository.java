package com.example.exampractice.repository;

import com.example.exampractice.model.Rider;
import com.example.exampractice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider,Long> {

}
