package com.SprintProject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SprintProject.entities.Screen;
@Repository(value="IScreenRepository")
public interface IScreenRepository extends JpaRepository<Screen, Integer>{
	@Query("select s.rows*s.columns from screen s where s.screenId=:pdata")
	int initBooking(@Param("pdata")int screenId);
}
