package com.SprintProject.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.IScreenRepository;
import com.SprintProject.dao.IShowRepository;
import com.SprintProject.dao.ITheatreRepository;
import com.SprintProject.entities.Screen;
import com.SprintProject.entities.Show;
import com.SprintProject.entities.Theatre;

@Service(value="IShowService")
@Transactional(readOnly=true)
public class IShowServiceImpl implements IShowService {
	@Autowired
	IShowRepository repository;
	@Autowired
	IScreenRepository screenrepo;
	@Autowired
	ITheatreRepository theatrerepo;
	@Override
	@Transactional
	public Show addShow(Show show) {
		return repository.save(show);
	}
	@Override
	@Transactional
	public Show updateShow(Show show) {
		Show s = repository.findById(show.getShowId()).orElseThrow(
				() -> new EntityNotFoundException("No Movie found for the given ID"));
		s.setShowName(show.getShowName());
		return repository.save(s);
		
	}
	@Override
	@Transactional
	public Show removeShow(Show show) {
		Show s = repository.findById(show.getShowId()).orElseThrow(
				() -> new EntityNotFoundException("No Show found for the given ID"));
		repository.delete(show);
		return(s);
	}
	@Override
	public Show viewShow(int showid) {
		return repository.findById(showid).get();
	}
	@Override
	public List<Show> viewShowList(int theatreid) {
		return repository.findByTheatre(theatreid);
	}
	@Override
	public List<Show> viewShowList(LocalDateTime date) {
		
		return repository.findByShowStartTime(date);
	}
	@Override
	public List<Show> viewAllShows() {
		return  repository.findAll();
	}
	@Override
	@Transactional
	public Show addScreen(int screenId, int showId) {
		Show show = repository.findById(showId).orElseThrow(
				()-> new EntityNotFoundException("You don't have show with this id, check id"));
		Screen screen = screenrepo.findById(screenId).orElseThrow(
				()-> new EntityNotFoundException("You don't have screen with this id, check id"));
		show.setScreen(screen);	
		return repository.save(show);
	}
	@Override
	@Transactional
	public Show addTheatre (int theatreId, int showId) {
		Theatre theatre = theatrerepo.findById(theatreId).orElseThrow(
				()-> new EntityNotFoundException("You should be a customer to book ticket, check id"));
		Show show = repository.findById(showId).orElseThrow(
				()-> new EntityNotFoundException("You don't have show with this id, check id"));
		show.setTheatre(theatre);
		return repository.save(show);
	}
}
