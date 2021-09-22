package com.SprintProject.dao;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SprintProject.entities.TicketBooking;

public interface IBookingRepository extends JpaRepository<TicketBooking, Integer>{
	List<TicketBooking> findByMovieId(int movieId);
	List<TicketBooking> findByDate(LocalDate date);
	List<TicketBooking> findByShowId(int showId);
}




