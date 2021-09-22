package com.SprintProject.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.SprintProject.entities.Movie;

@Service
public interface IMovieService {
	
	public abstract Movie addMovie(Movie movie);
	public abstract Movie updateMovie(Movie movie);
	public abstract Movie removeMovie(int movieid);
	public abstract Movie viewMovie(int movieid);
	public abstract List<Movie> viewMovieList();
	public abstract List<Movie> viewMovieList(int theaterid);
	public abstract List<Movie> viewMovieList(LocalDate date);
	

}