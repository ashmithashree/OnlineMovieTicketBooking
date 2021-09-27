package com.SprintProject.service;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.SprintProject.entities.Movie;
import com.SprintProject.entities.Show;


public interface IMovieService {
	
	public abstract Movie addMovie(Movie movie,int theatreId);
	public abstract Movie updateMovie(Movie movie);
	public abstract Movie removeMovie(int movieid);
	public abstract Movie viewMovie(int movieid);
	public abstract List<Movie> viewMovieList();
	public abstract List<Movie> viewMovieList(int theaterid);
	public abstract List<Movie> viewMovieList(LocalDateTime date);
	public abstract Movie addTheater(int theatreId, int movieId);
	public abstract Movie addShow(Show showId, int movieId);
	

}
