package com.SprintProject.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.User;
@Repository(value="IUserRepository")
public interface IUserRepository extends JpaRepository<User, Integer> {

}