package com.SprintProject.service;


import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.IShowRepository;
import com.SprintProject.entities.Show;

@Service(value="IShowService")
@Transactional(readOnly=true)
public class IShowServiceImpl implements IShowService {
	@Autowired
	IShowRepository repository;
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
	public Show viewShow(Show show) {
		return repository.findById(show.getShowId()).get();
	}
	@Override
	public List<Show> viewShowList(int theaterid) {
		return repository.findByTheaterId(theaterid);
	}
	@Override
	public List<Show> viewShowList(LocalDateTime date) {
		return repository.findByshowStartTime(date);
	}
	@Override
	public List<Show> viewAllShows() {
		return  repository.findAll();
	}

}
