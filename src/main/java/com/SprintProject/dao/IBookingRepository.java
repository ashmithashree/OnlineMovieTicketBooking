package com.SprintProject.dao;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SprintProject.entities.TicketBooking;
@Repository(value="IBookingRepository")
public interface IBookingRepository extends JpaRepository<TicketBooking, Integer>{
	@Query("select t from ticketbooking t join fetch t.showId s join fetch s.movie m where m.movieId=:pdata")
	List<TicketBooking> findByMovieId(@Param("pdata")int movieId);
	List<TicketBooking> findBybookingDate(LocalDate date);
	List<TicketBooking> findByShowId(int showId);
//	@Query("select t.noOfSeats*s.price from ticketbooking tb join fetch tb.ticket t join fetch t.seatNumber s where ticketBookId=:pdata " )
//	double calculateTotalCost(@Param("pdata")int bookingid);

	
}