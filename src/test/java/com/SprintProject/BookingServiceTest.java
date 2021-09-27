package com.SprintProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.SprintProject.dao.IBookingRepository;
import com.SprintProject.entities.TicketBooking;
import com.SprintProject.service.IBookingServiceImpl;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
	@Mock
	private IBookingRepository bookingRepo;
	@InjectMocks
	private IBookingServiceImpl bookingService;

	@Test
	void showAllBookingtest() {
		
		List<TicketBooking> list = new ArrayList<TicketBooking>();
		LocalDate Sdate = LocalDate.parse("2021-09-26");
		TicketBooking TB = new TicketBooking(1,Sdate,5,"NetBanking","Successful",205.10);
		list.add(TB);
		
		when(bookingRepo.findByBookingDate(Sdate)).thenReturn(list);
		List<TicketBooking> ticket = bookingService.showAllBooking(Sdate);
		assertEquals(1, ticket.size());
	}
	@Test
	void addBookingTest() {
		LocalDate Sdate = LocalDate.parse("2021-09-26");
		TicketBooking TB = new TicketBooking(1,Sdate,5,"NetBanking","Successful",205.10);
		when(bookingRepo.save(TB)).thenReturn(TB);
		TicketBooking saveticket= bookingService.addBooking(TB);
		assertThat(saveticket).isNotNull();
		assertEquals(1, saveticket.getTicketBookId());
		
	}

}
