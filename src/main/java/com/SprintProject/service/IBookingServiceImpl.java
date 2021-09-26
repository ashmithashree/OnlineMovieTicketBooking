package com.SprintProject.service;

import com.SprintProject.entities.Customer;
import com.SprintProject.entities.Show;
import com.SprintProject.entities.Ticket;
import com.SprintProject.entities.TicketBooking;
import com.SprintProject.HouseFullException;
import com.SprintProject.dao.IBookingRepository;
import com.SprintProject.dao.ICustomerRepository;
import com.SprintProject.dao.IShowRepository;
import com.SprintProject.dao.ITicketRepository;
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
    @Autowired
    ISeatServiceImpl seatService;
    @Autowired
    ICustomerRepository custrepo;
    @Autowired
    IShowRepository showrepo;
    @Autowired
    ITicketRepository ticketrepo;
    int totalSeatInScreen1;
    int totalSeatInScree2;
    int totalSeatInScreen3;
	@Override
	@Transactional
	public TicketBooking addBooking(TicketBooking booking) {
		repository.save(booking);
		
		//int no_of_seats_available=repository.ticketAvailablityInScreen(booking.getTicketBookId());
		//int	no_of_seats_asked=repository.ticketRequested(booking.getTicketBookId());
//		if(no_of_seats_asked<no_of_seats_available)
//		{	
//			seatService.bookSeat(no_of_seats_asked);
//			
		return booking;
//		}
//		else 
//			throw new HouseFullException(null);
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
		List<TicketBooking> tic = repository.findBybookingDate(date);
		return tic;
		
	}

	@Override
	public List<TicketBooking> showBookingList(int showId) {
		List<TicketBooking> tic = repository.findByShow(showId);
		return tic;
	}

	@Override
	public double calculateTotalCost(int bookingid) {
		// TODO Auto-generated method stub
		return 0;//repository.calculateTotalCost(bookingid);
	}

	@Override
	public void initBooking(int screenId) {
		// TODO Auto-generated method stub
		//if()
		//=repository.initBooking(screenId);
		
	}
	@Override
	@Transactional
	public TicketBooking addCustomer(int customerId, int ticketBookId) {
		Customer customer = custrepo.findById(customerId).orElseThrow(
				()-> new EntityNotFoundException("You should be a customer to book ticket, check id"));
		TicketBooking ticketbook=repository.findById(ticketBookId).orElseThrow(
				()-> new EntityNotFoundException("No Ticked Booked in this Id, check id"));
		ticketbook.setCustomer( customer);	
		return repository.save(ticketbook);
	}

	@Override
	@Transactional
	public TicketBooking addShow(int showId, int ticketBookId) {
		// TODO Auto-generated method stub
		Show show = showrepo.findById(showId).orElseThrow(
				()-> new EntityNotFoundException("There is no show avaliable in this show id, check id"));
		TicketBooking ticketbook=repository.findById(ticketBookId).orElseThrow(
				()-> new EntityNotFoundException("No Ticked Booked in this Id, check id"));
		ticketbook.setShow(show);	
		return repository.save(ticketbook);
	}

	@Override
	@Transactional
	public TicketBooking addTicket(int ticketId, int ticketBookId) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketrepo.findById(ticketId).orElseThrow(
				()-> new EntityNotFoundException("There is no ticket in this ticket id, check id"));
		TicketBooking ticketbook=repository.findById(ticketBookId).orElseThrow(
				()-> new EntityNotFoundException("No Ticked Booked in this Id, check id"));
		ticketbook.setTicket(ticket);	
		return repository.save(ticketbook);
	}
	

	

}