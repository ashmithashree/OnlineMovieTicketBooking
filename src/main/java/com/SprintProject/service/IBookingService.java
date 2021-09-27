package com.SprintProject.service;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.SprintProject.entities.TicketBooking;
import java.util.List;

public interface IBookingService {
	public abstract List<String> addBooking(TicketBooking booking, int customerId, int showId);
	public abstract TicketBooking updateBooking(TicketBooking booking);
	public abstract TicketBooking cancelBooking(TicketBooking booking);
	public abstract List<TicketBooking> showAllBooking(int movieId);
	public abstract List<TicketBooking> showAllBooking(LocalDate date);
	public abstract List<TicketBooking> showBookingList(int showId);
    public abstract double calculateTotalCost(int bookingid);
	public abstract void initBooking(int screenId);
}
