package com.SprintProject.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.entities.TicketBooking;
import com.SprintProject.service.IBookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	IBookingServiceImpl bookingService;
	
	@PostMapping("/booking")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TicketBooking> addBooking(@Valid @RequestBody TicketBooking booking) {
		TicketBooking booking1 =bookingService.addBooking(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(booking1.getTicketBookId())
				.toUri();
		return ResponseEntity.created(location).body(booking1);
	}
	
	@PutMapping("/Ticket")
	public TicketBooking updateBooking(@Valid @RequestBody TicketBooking booking) {
		return bookingService.updateBooking(booking);
	}
	
	@DeleteMapping("/delete/{booking}")
	public TicketBooking cancelBooking(@PathVariable TicketBooking booking) {
		return bookingService.cancelBooking(booking);
	}
	
	@GetMapping("/BookingList/{movieId}")
	public List<TicketBooking> showAllBooking(@PathVariable(name ="movieId") int movieId) {
		return bookingService.showAllBooking(movieId);
	}
	@GetMapping("/BookDate/{date}")	
	public List<TicketBooking> showAllBooking(@PathVariable(name ="date") LocalDate date) {
		return bookingService.showAllBooking(date);
	}
	@GetMapping("/BookingShowId/{showid}")
	public List<TicketBooking> showBookingList(@PathVariable(name ="showid")int showId) {
		return bookingService.showBookingList(showId);
	}
	@GetMapping("/Cost/{id}")
	public double calculateTotalCost(@PathVariable(name ="id") int bookingid) {
		return bookingService.calculateTotalCost(bookingid);
	}
}
