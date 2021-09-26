package com.SprintProject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.IMovieRepository;
import com.SprintProject.dao.IShowRepository;
import com.SprintProject.dao.ITheatreRepository;
import com.SprintProject.entities.Movie;
import com.SprintProject.entities.Show;
import com.SprintProject.entities.Theatre;
import com.SprintProject.entities.TicketBooking;

@Service(value="IMovieService")
@Transactional(readOnly=true)
public class IMovieServiceImpl implements IMovieService {
	@Autowired
	IMovieRepository repository;
	@Autowired
	ITheatreRepository theatrerepo;
	@Autowired
	IShowRepository showrepo;
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
		
		return repository.save(mov);
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
		List<Movie> mov = repository.findByTheatre(theaterid);
		return mov;
	}

	@Override
	public List<Movie> viewMovieList(LocalDateTime date) {
		List<Movie> mov = repository.findByDate(date);
		return mov;
	}
	@Override
	@Transactional
	public Movie addTheater(int theatreId, int movieId) {
		// TODO Auto-generated method stub
		Theatre theatre= theatrerepo.findById(theatreId).orElseThrow(
				()-> new EntityNotFoundException("There is no Theatre with this id, check id"));
		Movie movie= repository.findById(movieId).orElseThrow(
				()-> new EntityNotFoundException("There is no Movie with this id, check id"));
		movie.setTheatre(theatre);	
		return repository.save(movie);
	}
	@Override
	@Transactional
	public Movie addShow(Show showId, int movieId) {
		// TODO Auto-generated method stub
//		Show show = showrepo.findById(showId).orElseThrow(
//				()-> new EntityNotFoundException("There is no show avaliable in this show id, check id"));
		Movie movie=repository.findById(movieId).orElseThrow(
				()-> new EntityNotFoundException("No Movie in this Id, check id"));
		movie.setShow(showId);	
		return repository.save(movie);
	}
}
