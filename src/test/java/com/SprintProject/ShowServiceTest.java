package com.SprintProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.SprintProject.dao.IShowRepository;
import com.SprintProject.entities.Show;
import com.SprintProject.service.IShowServiceImpl;

@ExtendWith(MockitoExtension.class)
class ShowServiceTest {
	@Mock
	private IShowRepository showRepo;
	@InjectMocks
	private IShowServiceImpl showService;

	@Test
	void viewAllShowsTest() {
		List<Show> list = new ArrayList<Show>();
		LocalDateTime StartDateTime = LocalDateTime.parse("2021-09-26T08:11:30");
		LocalDateTime EndDateTime = LocalDateTime.parse("2021-09-26T08:11:30");
		Show s = new Show(1,StartDateTime,EndDateTime,"Matinee");
		list.add(s);
		
		when(showRepo.findAll()).thenReturn(list);
		List<Show> show= showService.viewAllShows();
		
		assertEquals(1, show.size());
	}
	
	@Test
	void addShowTest() {

		LocalDateTime StartDateTime=LocalDateTime.parse("2021-09-26T10:11:30");
		LocalDateTime EndDateTime = LocalDateTime.parse("2021-09-26T08:11:30");
		Show s = new Show(1,StartDateTime,EndDateTime,"Matinee");
		
		when(showRepo.save(s)).thenReturn(s);
		Show saveShow= showService.addShow(s);
		assertThat(saveShow).isNotNull();
		assertEquals("Matinee", saveShow.getShowName());
		
	}
	

}
