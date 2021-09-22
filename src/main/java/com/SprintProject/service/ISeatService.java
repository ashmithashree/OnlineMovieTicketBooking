package com.SprintProject.service;

import com.SprintProject.entities.Seat;

public interface ISeatService {
	public abstract Seat bookSeat(Seat seat);
	public abstract  Seat cancleSeatBooking(Seat seat);
	public abstract Seat blockSeat(Seat seat);

}
