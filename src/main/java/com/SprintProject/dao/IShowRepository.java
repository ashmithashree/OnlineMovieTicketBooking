package com.SprintProject.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintProject.entities.Show;

public interface IShowRepository extends JpaRepository<Show, Integer>{

	List<Show> findByTheaterId(int theaterid);

	Show findAll(Show show);

	List<Show> findByDate(LocalDate date);

}
