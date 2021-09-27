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
import org.mockito.junit.jupiter.MockitoExtension;
import com.SprintProject.dao.IMovieRepository;
import com.SprintProject.entities.Movie;
import com.SprintProject.service.IMovieServiceImpl;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {
	@Mock
	private IMovieRepository movieRepo;
	@InjectMocks
	private IMovieServiceImpl movieService;

	@Test
	void viewMovieListtest() {
		List<Movie> list = new ArrayList<Movie>();
		Movie m = new Movie(1,"movie1","comedy","2","tamil","funny");
		Movie m1 = new Movie(2,"movie2","fun","2.5","english","comedy");
		list.add(m);
		list.add(m1);
		
		when(movieRepo.findAll()).thenReturn(list);
		List<Movie> mov = movieService.viewMovieList();	
		
		assertEquals(2, mov.size());
	}
	@Test
	void addMovieTest() {
		Movie mov = new Movie(1, "mov1","thriller","2.5","english","horror");
		when(movieRepo.save(mov)).thenReturn(mov);
		Movie saveMov = movieService.addMovie(mov);
		assertThat(saveMov).isNotNull();
		assertEquals("mov1", saveMov.getMovieName());
		
	}
	
}
