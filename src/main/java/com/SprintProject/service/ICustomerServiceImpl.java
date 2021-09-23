package com.SprintProject.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.ICustomerRepository;
import com.SprintProject.entities.Customer;

@Service(value="ICustomerService")
@Transactional(readOnly=true)
public class ICustomerServiceImpl implements ICustomerService{
	@Autowired
    ICustomerRepository repository;
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		Customer cust =repository.findById(customer.getCustomerId()).orElseThrow(
				() -> new EntityNotFoundException("no customer found by the id"));
		cust.setEmail(customer.getEmail());
		return repository.save(cust); 
	
	}

	@Override
	@Transactional
	public Customer deleteCustomer(Customer customer) {
		Customer cust = repository.findById(customer.getCustomerId()).orElseThrow(
				() -> new EntityNotFoundException("No Customer found for this id"));
		repository.deleteById(customer.getCustomerId());
		return cust;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Customer cust = repository.findById(customerId).get();
	      return cust;
	}

	@Override
	public List<Customer> viewAllCustomers(int movieid) {
		//List<Customer> cust = repository.findByMovieId(movieid);
		return null;
	}



}