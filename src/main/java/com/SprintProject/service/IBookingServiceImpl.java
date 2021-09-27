package com.SprintProject.service;

import com.SprintProject.entities.Customer;
import com.SprintProject.entities.Screen;
import com.SprintProject.entities.Seat;
import com.SprintProject.entities.Show;
import com.SprintProject.entities.Ticket;
import com.SprintProject.entities.TicketBooking;
import com.SprintProject.HouseFullException;
import com.SprintProject.dao.IBookingRepository;
import com.SprintProject.dao.ICustomerRepository;
import com.SprintProject.dao.IScreenRepository;
import com.SprintProject.dao.ISeatRepository;
import com.SprintProject.dao.IShowRepository;
import com.SprintProject.dao.ITicketRepository;
import com.SprintProject.service.IBookingService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    ISeatRepository seatrepo;
    @Autowired
    IScreenRepository screenrepo;
    int totalSeatInScreen1;
    int totalSeatInScreen2=0;
    int totalSeatInScreen3=0;
	@Override
	@Transactional
	public List<String> addBooking(TicketBooking booking, int customerId,int showId) {
		Customer customer = custrepo.findById(customerId).orElseThrow(
				()-> new EntityNotFoundException("You should be a customer to book ticket, check id"));
		Show show = showrepo.findById(showId).orElseThrow(
				()-> new EntityNotFoundException("There is no show avaliable in this show id, check id"));
		booking.setShow(show);
		booking.setCustomer(customer);	
		repository.save(booking);
		int no_of_seats_available=repository.ticketAvailablityInScreen(booking.getTicketBookId());//100
		int	no_of_seats_asked=repository.ticketRequested(booking.getTicketBookId());//10
		totalSeatInScreen2-=no_of_seats_asked;//90
		System.out.println(totalSeatInScreen1+" "+totalSeatInScreen2+" "+totalSeatInScreen3);
		
		if(totalSeatInScreen2<=no_of_seats_available)
		{	
			List<Integer>al=seatService.bookSeat(no_of_seats_asked,booking.getTicket());
			List<String> seatnumber=new ArrayList<String>();
			for(int seat:al)
			{
				Seat s=seatrepo.findById(seat).get();
				seatnumber.add(s.getSeatNumber());
				
			}
			return seatnumber;
		}			
		else 
		{
			totalSeatInScreen3+=no_of_seats_asked;
			throw new HouseFullException(null);
		}
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
		List<TicketBooking> tic = repository.findByShow(showId);
		return tic;
	}

	@Override
	public double calculateTotalCost(int bookingid) {
		// TODO Auto-generated method stub
		return repository.calculateTotalCost(bookingid);
	}

	@Override
	@Transactional
	public void initBooking(int screenId) {
		// TODO Auto-generated method stub
		Screen s = screenrepo.findById(screenId).orElseThrow(
				()-> new EntityNotFoundException("You dont have a screen with this id, check id"));
		int num=screenrepo.initBooking(screenId);
		if(s.getScreenName().equals("screen 1"))
		{
			totalSeatInScreen1=num;
			System.out.println(totalSeatInScreen1);
		}
		else if(s.getScreenName().equals("screen 2"))
		{
			totalSeatInScreen2=num;
			System.out.println(totalSeatInScreen2);
		}
		else
		{
			totalSeatInScreen3=num;
			System.out.println(totalSeatInScreen3);
		}
	}
}