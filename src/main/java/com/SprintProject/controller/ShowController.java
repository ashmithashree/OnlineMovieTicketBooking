package com.SprintProject.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.entities.Screen;
import com.SprintProject.entities.Show;
import com.SprintProject.service.IShowService;


@RestController
@RequestMapping("/show")
public class ShowController {
	@Autowired
	IShowService showService;
	
	@GetMapping("/ById/{id}")
	public Show viewShow(@PathVariable(name="id") int showid) {
		return showService.viewShow(showid);
	}
	@RequestMapping(value = "/ByTheater/{theatreId}", method = RequestMethod.GET)
	public List<Show> viewShowList(@PathVariable(name="theatreId") int theatreid) {
		return showService.viewShowList(theatreid);
	}
	
	@GetMapping("/ByDate/{date}")
	public List<Show> viewShowList(@RequestParam("date")CharSequence dateTime) {
		LocalDateTime StartDateTime=LocalDateTime.parse(dateTime);
		return showService.viewShowList(StartDateTime);
	}
	
	@GetMapping("/shows")
	public List<Show> viewAllShows() {
		return showService.viewAllShows();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Show> addShow(@Valid @RequestBody Show show) {
		Show s = showService.addShow(show);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(s.getShowId())
				.toUri();
		return ResponseEntity.created(location).body(show);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Show> updateMovie(@Valid @RequestBody Show show){
		Show s = showService.updateShow(show);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(s.getShowId())
				.toUri();
		return ResponseEntity.created(location).body(show);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Show removeShow(@Valid @RequestBody Show show) {
		return showService.removeShow(show);
	}
	@RequestMapping(value = "/screenAddition/{showId}/{screenId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> addScreen(@PathVariable("screenId") int screenId,@PathVariable("showId") int showId) {
		Show showtheatre=showService.addScreen( screenId,  showId);
		return ResponseEntity.accepted().body(showtheatre+ " Added successfully");
	}
	@RequestMapping(value = "/theaterAddition/{showId}/{theatreId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> addTheatre (@PathVariable("theatreId")int theatreId,@PathVariable("showId") int showId) {
		Show showtheatre=showService.addTheatre (theatreId, showId);
		return ResponseEntity.accepted().body(showtheatre + " Added successfully");
	}
	
	
}
