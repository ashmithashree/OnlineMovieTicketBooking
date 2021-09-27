package com.SprintProject.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="ticketbooking")
@Table(name="ticketbooking")
public class TicketBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int ticketBookId;
	LocalDate bookingDate;
	int transactionId;
	String transactionMode;
	String transactionStatus;
	double totalCost;
	
	public TicketBooking(int ticketBookId, LocalDate bookingDate, int transactionId, String transactionMode, String transactionStatus, double totalCost) {
		this.ticketBookId=ticketBookId;
		this.bookingDate=bookingDate;
		this.transactionId=transactionId;
		this.transactionStatus=transactionStatus;
		this.transactionMode=transactionMode;
		this.totalCost=totalCost;
	}
	
	public TicketBooking() {
		
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="show_id")
	private Show showId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="customerId", nullable =false)

	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="ticketId")
	private Ticket ticket;

	public int getTicketBookId() {
		return ticketBookId;
	}

	public void setTicketBookId(int ticketBookId) {
		this.ticketBookId = ticketBookId;
	}

	public Show getShowId() {
		return showId;
	}

	public void setShowId(Show showId) {
		showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
     
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}