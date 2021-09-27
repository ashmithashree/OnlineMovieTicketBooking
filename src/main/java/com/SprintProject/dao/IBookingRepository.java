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
	@Query("select t from ticketbooking t join fetch t.show s join fetch s.movie m where m.movieId=:pdata")
	List<TicketBooking> findByMovieId(@Param("pdata")int movieId);
	@Query("select t from ticketbooking t where t.bookingDate=:pdata")
	List<TicketBooking> findByBookingDate(@Param("pdata")LocalDate date);
	@Query("select t from ticketbooking t join fetch t.show s where s.showId=:pdata")
	List<TicketBooking> findByShow(@Param("pdata")int showId);
	
	@Query("select t.noOfSeats*200 from ticketbooking tb join tb.ticket t where tb.ticketBookId=:pdata " )
	double calculateTotalCost(@Param("pdata")int bookingid);
	
	@Query("select s.rows*s.columns from ticketbooking tb join tb.show sh join sh.screen s where tb.ticketBookId=:pdata")
	int ticketAvailablityInScreen(@Param("pdata")int ticketBookid);
	
	@Query("select t.noOfSeats from ticketbooking tb join tb.ticket t where tb.ticketBookId=:pdata")
	int ticketRequested(@Param("pdata") int ticketBookId);

}