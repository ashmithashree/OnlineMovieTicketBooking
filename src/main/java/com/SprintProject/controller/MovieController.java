package com.SprintProject.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.SprintProject.entities.Movie;
import com.SprintProject.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	IMovieService movieService;
	
	@GetMapping("/{id}")
	public Movie viewMovie(@Valid @RequestBody int movieid) {
		return movieService.viewMovie(movieid);
	}
	
	@GetMapping
    public List<Movie> viewMovieList(@PathVariable int theaterid) {
		return movieService.viewMovieList(theaterid);
	}
	
	@GetMapping
	public List<Movie> viewMovieList(@PathVariable LocalDateTime date) {
		return movieService.viewMovieList(date);
	}
	
	@GetMapping
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
	
	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		Movie mov = movieService.addMovie(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(mov.getMovieId())
				.toUri();
		return ResponseEntity.created(location).body(movie);
	}
	
	@DeleteMapping("/{id}")
	public Movie removeMovie(@Valid @RequestBody int movieid) {
		return movieService.removeMovie(movieid);
	}

}