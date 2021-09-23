package com.SprintProject.dao;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Show;

@Repository(value="IShowRepository")
public interface IShowRepository extends JpaRepository<Show, Integer>{
	List<Show> findByTheaterId(int theaterid);
	List<Show> findByshowStartTime(LocalDateTime date);

}
