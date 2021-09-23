package com.SprintProject.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Seat;
@Repository(value="ISeatRepository")
public interface ISeatRepository extends JpaRepository<Seat, Integer> {
	
}
