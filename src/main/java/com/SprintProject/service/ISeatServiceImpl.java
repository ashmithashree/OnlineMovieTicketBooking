package com.SprintProject.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.ISeatRepository;
import com.SprintProject.entities.Seat;
@Service(value="ISeatService")
@Transactional(readOnly=true)
public class ISeatServiceImpl implements ISeatService {
	@Autowired
	ISeatRepository repository;

	@Override
	@Transactional
	public Seat bookSeat(Seat seat) {
		Seat s=repository.save(seat);
		return s;
	}

	@Override
	@Transactional
	public Seat cancleSeatBooking(Seat seat) {
		Seat s = repository.findById(seat.getSeatId()).orElseThrow(
				() -> new EntityNotFoundException("No Seat found for the given ID"));
		        repository.delete(seat);
		 return s;
	}

	@Override
	@Transactional
	public Seat blockSeat(Seat seat) {
		
		return null;
	}

}
