package com.SprintProject.controller;

import java.net.URI;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.SprintProject.entities.Show;
import com.SprintProject.service.IShowService;


@RestController
@RequestMapping("/Show")
public class ShowController {
	@Autowired
	IShowService showService;
	
	@GetMapping("/showid/{id}")
	public Show viewShow(@PathVariable(name="id") int showid) {
		return showService.viewShow(showid);
	}
	
	@GetMapping("/showlist/{theaterid}")
	public List<Show> viewShowList(@PathVariable(name="theaterid") int theaterid) {
		return showService.viewShowList(theaterid);
	}
	
	@GetMapping("/showdate/{date}")
	public List<Show> viewShowList(@PathVariable(name="date")  LocalDateTime date) {
		return showService.viewShowList(date);
	}
	
	@GetMapping("/shows")
	public List<Show> viewAllShows() {
		return showService.viewAllShows();
	}
	
	@PostMapping
	public ResponseEntity<Show> addShow(@Valid @RequestBody Show show) {
		Show s = showService.addShow(show);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(s.getShowId())
				.toUri();
		return ResponseEntity.created(location).body(show);
	}
	
	@PutMapping
	public ResponseEntity<Show> updateMovie(@Valid @RequestBody Show show){
		Show s = showService.updateShow(show);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(s.getShowId())
				.toUri();
		return ResponseEntity.created(location).body(show);
	}
	
	@DeleteMapping
	public Show removeShow(@Valid @RequestBody Show show) {
		return showService.removeShow(show);
	}

}