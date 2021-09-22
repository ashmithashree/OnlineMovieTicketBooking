package com.SprintProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintProject.entities.Show;

public interface IShowRepository extends JpaRepository<Show, Integer>{

	List<Show> findByTheaterId(int theaterid);

	Show findAll(Show show);

}
