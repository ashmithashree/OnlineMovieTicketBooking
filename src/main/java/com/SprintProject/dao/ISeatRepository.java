package com.SprintProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintProject.entities.Seat;


public interface ISeatRepository extends JpaRepository<Seat, Integer> {

}
