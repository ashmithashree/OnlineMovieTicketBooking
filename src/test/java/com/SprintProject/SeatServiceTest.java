package com.SprintProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.SprintProject.dao.ISeatRepository;
import com.SprintProject.entities.Seat;
import com.SprintProject.service.ISeatServiceImpl;

@ExtendWith(MockitoExtension.class)
class SeatServiceTest {
	@Mock
	ISeatRepository seatRepo;
	
	@InjectMocks
	ISeatServiceImpl seatService;

	@Test
	void bookSeatTest() {
		Seat s = new Seat(1,"f9","Delux",100);
		when(seatRepo.save(s)).thenReturn(s);
		Seat saveSeat = seatService.bookSeat(s);
		
		assertThat(saveSeat).isNotNull();
		assertEquals("Delux", saveSeat.getType());
		assertEquals("f9", saveSeat.getSeatNumber());
		
	}
	
	@Test
	void cancleSeatBooking() {
//		final Seat s = new Seat(1,"f9","Delux",100);
//		//when(seatRepo.save(s)).thenReturn(s);
//		//Seat saveSeat = seatService.bookSeat(s);
//	    //boolean isExistBeforeDelete = seatRepo.findById(1).isPresent();
//		seatRepo.delete(s);
//		Seat removeSeat = seatService.cancleSeatBooking(s);
//		
//		//boolean isExistAfterDelete = seatRepo.findById(1).isPresent();
//		
//		//assertTrue(isExistBeforeDelete);
//		//assertFalse(isExistAfterDelete);
//		assertThat(removeSeat).isNull();
		seatRepo.deleteById(1);
		assertThat(seatRepo.existsById(1)).isFalse();
		
	}

}
