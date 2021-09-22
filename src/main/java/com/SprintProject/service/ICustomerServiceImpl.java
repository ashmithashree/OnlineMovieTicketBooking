package com.SprintProject.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.SprintProject.dao.ICustomerRepository;
import com.SprintProject.entities.Customer;
import com.SprintProject.entities.TicketBooking;

public class ICustomerServiceImpl implements ICustomerService{
	@Autowired
    ICustomerRepository repository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust =repository.findBycustomerId(customer.getCustomerId()).orElseThrow(
				() -> new EntityNotFoundException("no customer found by the id"));
		cust.setCustomerEmail(cust.getCustomerEmail());
		return repository.save(cust); 
	
	}

	@Override
	public Customer delectCustomer(Customer customer) {
		
		
	}

	@Override
	public Customer viewCustomer(int custid) {
		
		Customer cust = repository.findById(custid);
	      return cust;
	}

	@Override
	public List<Customer> viewAllCustomers(int movieid) {
		List<Customer> cust = repository.findByMovieId(movieid);
		return cust;
	}

}
