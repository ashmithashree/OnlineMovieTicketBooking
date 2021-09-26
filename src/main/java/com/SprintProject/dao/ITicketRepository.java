package com.SprintProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.SprintProject.entities.Ticket;
@Repository(value="ITicketRepository")
public interface ITicketRepository  extends JpaRepository<Ticket, Integer> {

}