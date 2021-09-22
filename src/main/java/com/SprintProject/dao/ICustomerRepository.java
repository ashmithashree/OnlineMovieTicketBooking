package com.SprintProject.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Customer;

@Repository(value="ICustomerRepository")
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findByMovieId(int movieid);
}