package com.SprintProject.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.ISeatRepository;
import com.SprintProject.entities.Seat;
import com.SprintProject.entities.Ticket;
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
		
		return repository.save(seat);
	}
	
	@Override
	public List<Integer> bookSeat(int seat, Ticket ticket) {
		// TODO Auto-generated method stub
		List<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<seat;i++)
		{
			Seat seat1=new Seat();
			int asciivalue = 'A'+n; 
			String str = Character.toString((char) asciivalue+i);
			seat1.setSeatNumber(str+n);
			seat1.setPrice(200);
			seat1.setBooked("yes");
			seat1.setTicket(ticket);
			repository.save(seat1);
			al.add(seat1.getSeatId());
		}
		n+=seat;
		return al; 
	}

}
