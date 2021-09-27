package com.SprintProject.service;

import java.util.ArrayList;
import java.util.List;

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

	
	int n=1;
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
	
	@Override
	public List<Integer> bookSeat(int seat) {
		// TODO Auto-generated method stub
		List<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<seat;i++)
		{
			Seat s=repository.findById(n+i).orElseThrow(
				 	() -> new EntityNotFoundException("No Seat found for the given ID"));
			s.setBooked("yes");
			al.add(s.getSeatId());
		}
		n+=seat;
		return al; 
	}

}
