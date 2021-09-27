package com.SprintProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="ticket")
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int ticketId;
	int noOfSeats;
	boolean ticketStatus;
	
	@OneToMany(mappedBy ="ticket", cascade = CascadeType.ALL)
	List<Seat> seatNumber =new ArrayList<Seat>();
	
	@OneToOne(mappedBy="ticket")
	private TicketBooking ticketBookingref;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public List<Seat> getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(List<Seat> seatNumber) {
		this.seatNumber= seatNumber;
		for(Seat s: seatNumber) {
			s.setTicket(this);
		}
	}
	@JsonIgnore
	public TicketBooking getTicketBookingref() {
		return ticketBookingref;
	}
	public void setTicketBookingref(TicketBooking ticketBookingref) {
		this.ticketBookingref = ticketBookingref;
	}
	public boolean isTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	

	
}
