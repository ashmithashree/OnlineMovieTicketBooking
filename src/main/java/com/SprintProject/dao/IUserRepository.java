package com.SprintProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SprintProject.entities.Roles;
import com.SprintProject.entities.TicketBooking;
import com.SprintProject.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}