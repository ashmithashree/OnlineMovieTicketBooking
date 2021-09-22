package com.SprintProject.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.SprintProject.entities.Movie;

@Service
public interface IMovieService {
	
	Movie addMovie(Movie movie);
	Movie updateMovie(Movie movie);
	Movie removeMovie(int movieid);
	Movie viewMovie(int movieid);
	List<Movie> viewMovieList();
	List<Movie> viewMovieList(int theaterid);
	List<Movie> viewMovieList(LocalDate date);
	

}
