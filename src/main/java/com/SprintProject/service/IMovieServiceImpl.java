package com.SprintProject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SprintProject.dao.IMovieRepository;
import com.SprintProject.entities.Movie;
import org.springframework.transaction.annotation.Transactional;
import com.SprintProject.dao.IMovieRepository;
import com.SprintProject.entities.Movie;

@Service(value="IMovieService")
@Transactional(readOnly=true)
public class IMovieServiceImpl implements IMovieService {
	@Autowired
	IMovieRepository repository;

	@Override

	@Transactional

	public Movie addMovie(Movie movie) {
		return repository.save(movie);
	}

	@Override

	@Transactional
	public Movie updateMovie(Movie movie) {
		Movie mov = repository.findById(movie.getMovieId()).orElseThrow(
				() -> new EntityNotFoundException("No Movie found for the given ID"));
		mov.setMovieGenre(movie.getMovieGenre());
		return repository.save(mov);
	}

	@Override
    @Transactional
	public Movie removeMovie(int movieid) {
		Movie mov = repository.findById(movieid).orElseThrow(
				            ()-> new EntityNotFoundException("No Customer found for the given ID"));
		            repository.deleteById(movieid);
		
		return mov;
	}

	@Override
	public Movie viewMovie(int movieid) {
		return repository.findById(movieid).get();
	}

	@Override
	public List<Movie> viewMovieList() {
		List<Movie> mov = repository.findAll();
		return mov;
	}

	@Override
	public List<Movie> viewMovieList(int theaterid) {

		List<Movie> mov = repository.findByTheater(theaterid);

		return mov;
	}

	@Override

	public List<Movie> viewMovieList(LocalDateTime date) {
		List<Movie> mov = repository.findByDate(date);
		return mov;
	}

	

}
