package com.SprintProject.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.entities.TicketBooking;
import com.SprintProject.service.IBookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	IBookingService bookingService;
	
	@PostMapping("/{customerId}/{showId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<String>> addBooking(@PathVariable(name="customerId")int customerId ,
			@RequestBody TicketBooking booking,@PathVariable(name="showId")int showId ) {
		List<String> booking1 =bookingService.addBooking(booking,customerId,showId);
		return ResponseEntity.created(null).body(booking1);
	}
	
	@PutMapping("/Ticket")
	public TicketBooking updateBooking( @RequestBody TicketBooking booking) {
		return bookingService.updateBooking(booking);
	}
	
	@DeleteMapping("/delete/{id}")
	public TicketBooking cancelBooking(@RequestBody TicketBooking booking) {
		return bookingService.cancelBooking(booking);
	}
	
	@GetMapping("/BookingList/{movieId}")
	public List<TicketBooking> showAllBooking(@PathVariable(name ="movieId") int movieId) {
		return bookingService.showAllBooking(movieId);
	}
	@GetMapping("/BookDate/{date}")	
	public List<TicketBooking> showAllBooking(@RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return bookingService.showAllBooking(date);
	}
	@RequestMapping(value = "/BookByShow/{showId}", method = RequestMethod.GET)
	public List<TicketBooking> showBookingList(@PathVariable(name ="showId")int showId) {
		return bookingService.showBookingList(showId);
	}
	@GetMapping("/Cost/{id}")
	public double calculateTotalCost(@PathVariable(name ="id") int bookingid) {
		return bookingService.calculateTotalCost(bookingid);
	}
	@PostMapping("/InitBooking/{screenId}")
	public ResponseEntity<String> initBooking(@PathVariable(name="screenId") int screenId)
	{
		bookingService.initBooking(screenId);
		return ResponseEntity.created(null).body("booking initiated");
	}
//	@RequestMapping(value = "/customerAddition/{ticketId}/{customerId}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public ResponseEntity<TicketBooking> addCustomer(@PathVariable(name="customerId")int customerId,@PathVariable(name="ticketId") int ticketbook) {
//		TicketBooking custticket= bookingService.addCustomer( customerId, ticketbook);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(customerId)
//				.toUri();
//		return ResponseEntity.created(location).body(custticket);
//	}
//	@RequestMapping(value = "/TicketAddition/{ticketbookId}/{ticketId}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public ResponseEntity<TicketBooking> addTicket(@PathVariable(name="ticketId")int ticketId,@PathVariable(name="ticketbookId") int ticketbook) {
//		TicketBooking ticket= bookingService.addTicket( ticketId, ticketbook);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(ticketbook)
//				.toUri();
//		return ResponseEntity.created(location).body(ticket);
//	}
//	@RequestMapping(value = "/showAddition/{ticketbookId}/{showId}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public ResponseEntity<TicketBooking> addShow(@PathVariable(name="showId")int showId,@PathVariable(name="ticketbookId") int ticketbook) {
//		TicketBooking ticket= bookingService.addShow( showId, ticketbook);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(ticketbook)
//				.toUri();
//		return ResponseEntity.created(location).body(ticket);
//	}
}
