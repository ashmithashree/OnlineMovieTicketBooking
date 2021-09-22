package com.SprintProject.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SprintProject.dao.ISeatRepository;
import com.SprintProject.entities.Seat;
@Service(value="ISeatService")
public class ISeatServiceImpl implements ISeatService {
	@Autowired
	ISeatRepository repository;

	@Override
	public Seat bookSeat(Seat seat) {
		return repository.save(seat);
	}

	@Override
	public Seat cancleSeatBooking(Seat seat) {
		Seat s = repository.findById(seat.getSeatId()).orElseThrow(
				() -> new EntityNotFoundException("No Seat found for the given ID"));
		        repository.delete(seat);
		 return s;
	}

	@Override
	public Seat blockSeat(Seat seat) {
		
		return null;
	}

}
