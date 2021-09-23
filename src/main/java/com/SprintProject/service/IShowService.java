package com.SprintProject.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.SprintProject.entities.Show;
import java.time.LocalDateTime;
import java.util.List;
import com.SprintProject.entities.Show;

public interface IShowService {
	public Show addShow(Show show) ;
	public abstract Show updateShow(Show show);
	public abstract Show removeShow(Show show);
	public abstract Show viewShow(Show show);
	public abstract List<Show> viewShowList(int theaterid);
	public abstract List<Show> viewAllShows();
	public abstract List<Show> viewShowList(LocalDateTime date);
}
