package com.SpringProject.Service;

public interface ISeatService {
	public abstract Seat bookSeat(Seat seat);
	public abstract  Seat cancleSeatBooking(Seat seat);
	public Seat blockSeat(Seat seat);
}
