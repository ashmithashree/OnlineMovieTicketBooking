package com.SprintProject.service;

import com.SprintProject.entities.TicketBooking;
import com.SprintProject.dao.IBookingRepository;
import com.SprintProject.service.IBookingService;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="IBookingService")
@Transactional(readOnly=true)
public class IBookingServiceImpl implements IBookingService {
    @Autowired
    IBookingRepository repository;
	@Override
	@Transactional
	public TicketBooking addBooking(TicketBooking booking) {
		return repository.save(booking);
    }

	@Override
	@Transactional
	public TicketBooking updateBooking(TicketBooking booking) {
		TicketBooking tic = repository.findById(booking.getTicketBookId()).orElseThrow(
				() -> new EntityNotFoundException("No booking found for this id"));
		tic.setBookingDate(booking.getBookingDate());
		return repository.save(tic);
				
	}

	@Override
	@Transactional
	public TicketBooking cancelBooking(TicketBooking booking) {
		TicketBooking tic = repository.findById(booking.getTicketBookId()).orElseThrow(
				() -> new EntityNotFoundException("No booking found for this id"));
		repository.deleteById(booking.getTicketBookId());
		return tic;
				
	}

	@Override
	public List<TicketBooking> showAllBooking(int movieId) {
		List<TicketBooking> tic = repository.findByMovieId(movieId);
		return tic;
	}

	@Override
	public List<TicketBooking> showAllBooking(LocalDate date) {
		List<TicketBooking> tic = repository.findByBookingDate(date);
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
		return 0;//repository.calculateTotalCost(bookingid);
	}

	

}