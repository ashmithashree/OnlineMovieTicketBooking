package com.SprintProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SprintProject.entities.Customer;
import com.SprintProject.entities.TicketBooking;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByMovieId(int movieid);

	



}