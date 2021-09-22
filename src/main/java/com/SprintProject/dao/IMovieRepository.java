package com.SprintProject.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SprintProject.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer>   {
	
	@Query("select distinct u from Movie u join fetch u.theater t " + "where t.theaterid = ?1")
	List<Movie> findByTheaterId(int theaterid);

	@Query("select distinct u from Movie u join fetch u.show s " + "where s.date = ?1")
	List<Movie> findByDate(LocalDate date);

}
