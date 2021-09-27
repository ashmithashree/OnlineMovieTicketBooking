package com.SprintProject.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.dao.ITheatreRepository;
import com.SprintProject.entities.Show;
import com.SprintProject.entities.Theatre;

@RestController
@RequestMapping("/Theater")
public class TheatreController {
	@Autowired
	ITheatreRepository service;
	@PostMapping
	public Theatre addTheater(@Valid @RequestBody Theatre show) {
		Theatre s = service.save(show);
		return s;
	}
}