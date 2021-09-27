package com.SprintProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Users;
@Repository(value="IUserRepository")
public interface IUserRepository extends JpaRepository<Users, Integer> {
	public Users findByUserName(String userName);
	public boolean existsByUserName(String userName);
}