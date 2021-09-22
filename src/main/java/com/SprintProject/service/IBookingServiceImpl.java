package com.SprintProject.service;

import com.SprintProject.entities.TicketBooking;
import com.SprintProject.dao.IBookingRepository;
import com.SprintProject.service.IBookingService;


import java.time.LocalDate;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;


public class IBookingServiceImpl implements IBookingService {
    @Autowired
    IBookingRepository repository;
	@Override
	public TicketBooking addBooking(TicketBooking booking) {
		return repository.save(booking);
    }

	@Override
	public TicketBooking updateBooking(TicketBooking booking) {
		TicketBooking tic = repository.findById(booking.getBookingId()).orElseThrow(
				() -> new EntityNotFoundException("No booking found for this id"));
		cust.setbookingDate(cust.getbookingDate());
		return repository.save(tic);
				
	}

	@Override
	public TicketBooking cancelBooking(TicketBooking booking) {
		TicketBooking tic = repository.findByBookingId(bookingid).orElseThrow(
				() -> new EntityNotFoundException("No booking found for this id"));
		return repository.save(tic);
				
	}

	@Override
	public List<TicketBooking> showAllBooking(int movieId) {
		List<TicketBooking> tic = repository.findByMovieId(movieId);
		return tic;
	}

	@Override
	public List<TicketBooking> showAllBooking(LocalDate date) {
		List<TicketBooking> tic = repository.findByDate(date);
		return tic;
		
	}

	@Override
	public List<TicketBooking> showBookingList(int showId) {
		List<TicketBooking> tic = repository.findByShowId(showId);
		return tic;
	}

	@Override
	public double calculateTotalCost(int bookingid) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
