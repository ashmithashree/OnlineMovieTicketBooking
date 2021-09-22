package com.SprintProject.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SprintProject.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer>   {
	
	List<Movie> findByTheaterId(int theaterid);

	List<Movie> findByDate(LocalDate date);

}
