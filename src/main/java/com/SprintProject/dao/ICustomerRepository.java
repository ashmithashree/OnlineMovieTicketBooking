package com.SprintProject.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.SprintProject.entities.Customer;

@Repository(value="ICustomerRepository")
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c from onlinecustomer c join fetch c.ticketId t join fetch t.showId s join fetch s.movie m where m.movieId=:pdata ")
	List<Customer> findByMovieId(@Param("pdata")int movieid);
}