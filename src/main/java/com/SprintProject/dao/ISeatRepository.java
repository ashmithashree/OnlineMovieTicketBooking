package com.SprintProject.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Seat;
@Repository(value="ISeatRepository")
public interface ISeatRepository extends JpaRepository<Seat, Integer> {
	@Query("select case when s.booked IS NULL then true else false end from seat s where s.id=:pdata ")
	boolean checkAvaliablity(@Param("pdata")int i);
	
}
