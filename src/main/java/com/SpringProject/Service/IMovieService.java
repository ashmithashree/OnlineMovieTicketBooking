package com.SpringProject.Service;

import java.time.LocalDate;
import java.util.List;

public interface IMovieService {
	public abstract Movie addMovie(Movie movie);
	public abstract Movie updateMovie(Movie movie);
	public abstract Movie removeMovie(int movieid);
	public abstract List<Movie> viewMovieList();
	public abstract List<Movie> viewMovieList(int theaterid);
	public abstract List<Movie> viewMovieList(LocalDate date);
	
}
