package com.SprintProject.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.SprintProject.entities.Show;

@Service
public interface IShowService {
	
	public abstract Show addShow(Show show);
	public abstract Show updateShow(Show show);
	public abstract Show removeShow(Show show);
	public abstract Show viewShow(Show show);
	public abstract List<Show> viewShowList(int theaterid);
	public abstract List<Show> viewShowList(LocalDate date);
	public abstract List<Show> viewAllShows();

}
