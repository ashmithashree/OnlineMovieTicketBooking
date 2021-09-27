package com.SprintProject.service;

import java.util.List;

import com.SprintProject.entities.Seat;
import com.SprintProject.entities.Ticket;

public interface ISeatService {
	public abstract  Seat cancleSeatBooking(Seat seat);
	public abstract Seat blockSeat(Seat seat);
	List<Integer> bookSeat(int seat, Ticket ticket);

}
