package com.SprintProject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.SprintProject.entities.Show;

public interface IShowService {
	public Show addShow(Show show) ;
	public abstract Show updateShow(Show show);
	public abstract Show removeShow(Show show);
	public abstract Show viewShow(int showid);
	public abstract List<Show> viewShowList(int theaterid);
	public abstract List<Show> viewShowList(LocalDateTime date);
	public abstract List<Show> viewAllShows();
}
