package com.SprintProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SprintProject.entities.Seat;
import com.SprintProject.service.ISeatService;

@RestController
@RequestMapping("/Seat")
public class SeatController {
	@Autowired
	ISeatService seatService;
	
	@DeleteMapping("/SeatRemove")
	public Seat removeSeat(@RequestBody Seat seat) {
		return seatService.cancleSeatBooking(seat);
	}
	

}
