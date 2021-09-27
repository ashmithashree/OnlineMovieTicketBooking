package com.SprintProject.controller;

import java.net.URI;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.SprintProject.entities.Movie;
import com.SprintProject.entities.Show;
import com.SprintProject.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	IMovieService movieService;
	
	@GetMapping("/{id}")
	public Movie viewMovie(@PathVariable(name="id") int movieid) {
		return movieService.viewMovie(movieid);
	}
	@RequestMapping(value = "/moviesbytheatre/{theatreId}", method = RequestMethod.GET)
    public List<Movie> viewMovieList(@PathVariable(name="theatreId") int theatreId) {
		return movieService.viewMovieList(theatreId);
	}
	
	@GetMapping("/moviesbydate/{date}")
	public List<Movie> viewMovieList(@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime date) {
		return movieService.viewMovieList(date);
	}
	
	@GetMapping("/movies")
	public List<Movie> viewMovieList() {
		return movieService.viewMovieList();
	}
	
	@PutMapping
	public ResponseEntity<Movie> updateMovie(@Valid @RequestBody Movie movie) {
		Movie mov = movieService.updateMovie(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(mov.getMovieId())
				.toUri();
		return ResponseEntity.created(location).body(movie);
	}
	
	@PostMapping("{theatreId}")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie,@PathVariable(name="theatreId") int theatreId) {
		Movie mov = movieService.addMovie(movie,theatreId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(mov.getMovieId())
				.toUri();
		return ResponseEntity.created(location).body(movie);
	}
	
	@DeleteMapping("/{movieId}")
	public Movie removeMovie(@PathVariable(name="movieId") int movieid) {
		return movieService.removeMovie(movieid);
	}
//	@RequestMapping(value = "/showAddition/{movieId}/{showId}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public ResponseEntity<Movie> addShow(@RequestBody Show showId,@PathVariable(name="movieId") int movieId) {
//		Movie mov= movieService.addShow(showId,movieId);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(movieId)
//				.toUri();
//		return ResponseEntity.created(location).body(mov);
//	}
//	@RequestMapping(value = "/theaterAddition/{movieId}/{theatreId}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public ResponseEntity<Movie> addTheatre(@PathVariable(name="theatreId") int theatreId,@PathVariable(name="movieId") int movieId) {
//		Movie mov= movieService.addTheater(theatreId,movieId);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(movieId)
//				.toUri();
//		return ResponseEntity.created(location).body(mov);
//	}


}