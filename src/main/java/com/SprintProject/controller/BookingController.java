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
	public ResponseEntity<?> addBooking(@PathVariable(name="customerId")int customerId ,
			@RequestBody TicketBooking booking,@PathVariable(name="showId")int showId ) {
		List<String> booking1 =bookingService.addBooking(booking,customerId,showId);
		return ResponseEntity.created(null).body("Thank you for booking!/nHere is you seats/n"+booking1+"/nEnjoy the Movie \uD83D\uDE00");
	}
	@PutMapping("/Ticket")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<?> updateBooking( @RequestBody TicketBooking booking) {
		TicketBooking booking1= bookingService.updateBooking(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(booking1.getTicketBookId())
				.toUri();
		return ResponseEntity.created(location).body(booking1 +" Updated Successfully \uD83D\uDE00");
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> cancelBooking(@RequestBody TicketBooking booking) {
		TicketBooking deleting = bookingService.cancelBooking(booking);
		return ResponseEntity.ok().body(deleting.getTicketBookId() + " Booking Cancelled. Oh! Not interested in this movie \uD83D\uDE15" );
	}
	@RequestMapping(value = "/ByMovie/{movieId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public List<TicketBooking> showAllBooking(@PathVariable(name ="movieId") int movieId) {
		List<TicketBooking> booking = bookingService.showAllBooking(movieId);
		return booking;
	}
	
	@RequestMapping(value = "/ByDate/{date}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public List<TicketBooking> showAllBooking(@RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		List<TicketBooking> booking = bookingService.showAllBooking(date);
		
		return booking ;
	}
	
	@RequestMapping(value = "/BookByShow/{showId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public  List<TicketBooking> showBookingList(@PathVariable(name ="showId")int showId) {
		List<TicketBooking> booking=bookingService.showBookingList(showId);
		return booking;
	}
	@GetMapping("/Cost/{id}")
	public ResponseEntity<?>  calculateTotalCost(@PathVariable(name ="id") int bookingid) {
		double b=bookingService.calculateTotalCost(bookingid);
		return ResponseEntity.created(null).body("Your total cost is: "+b);
	}
	@PostMapping("/InitBooking/{screenId}")
	public ResponseEntity<String> initBooking(@PathVariable(name="screenId") int screenId)
	{
		bookingService.initBooking(screenId);
		return ResponseEntity.created(null).body("booking initiated");
	}
}
