package com.SprintProject.service;

import java.util.List;

import com.SprintProject.entities.Seat;

public interface ISeatService {
	public abstract  Seat cancleSeatBooking(Seat seat);
	public abstract Seat blockSeat(Seat seat);
	public abstract List<Integer> bookSeat(int seat);

}
