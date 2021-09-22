package com.SprintProject.service;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SprintProject.dao.IShowRepository;
import com.SprintProject.entities.Show;

@Service
public class IShowServiceImpl implements IShowService {
	@Autowired
	IShowRepository repository;

	@Override
	public Show addShow(Show show) {
		return repository.save(show);
	}

	@Override
	public Show updateShow(Show show) {
		Show s = repository.findById(show.getShowId()).orElseThrow(
				() -> new EntityNotFoundException("No Movie found for the given ID"));
		s.setShowName(show.getShowName());
		return repository.save(s);
		
	}

	@Override
	public Show removeShow(Show show) {
		Show s = repository.findById(show.getShowId()).orElseThrow(
				() -> new EntityNotFoundException("No Show found for the given ID"));
		repository.delete(show);
		
		return(show);
	}

	@Override
	public Show viewShow(Show show) {
		return repository.findAll(show);
	}

	@Override
	public List<Show> viewShowList(int theaterid) {
		List<Show> s = repository.findByTheaterId(theaterid);
		return s;
	}

	@Override
	public List<Show> viewShowList(LocalDate date) {
		List<Show> s = repository.findByDate(date);
		return s;
	}

	@Override
	public List<Show> viewAllShows() {
		List<Show> s = repository.findAll();
		return s;
	}

}
