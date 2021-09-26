package com.SprintProject.service;

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

	
	int n=0;
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
		
		for(int i=n;i<seat;i++)
		{
			if(repository.checkAvaliablity(i));
			{
				
				//Seat c=findById(i);//update
			}
				
		}
		n+=seat;
		return null; 
	}

}
