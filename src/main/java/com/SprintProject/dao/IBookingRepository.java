package com.SprintProject.dao;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SprintProject.entities.TicketBooking;
@Repository(value="IBookingRepository")
public interface IBookingRepository extends JpaRepository<TicketBooking, Integer>{
	List<TicketBooking> findByMovieId(int movieId);
	List<TicketBooking> findByDate(LocalDate date);
	List<TicketBooking> findByShowId(int showId);
	@Query("select t.noOfSeats*s.price from ticket t join fetch t.seatNumber s where ticketBookingref=:?1" )
	double calculateTotalCost(int bookingid);

	
}