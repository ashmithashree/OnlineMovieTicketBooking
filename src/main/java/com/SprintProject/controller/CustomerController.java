package com.SprintProject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.entities.Customer;
import com.SprintProject.service.ICustomerServiceImpl;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
    ICustomerServiceImpl custService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer cust1 = custService.addCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cust1.getCustomerId())
				.toUri();
		return ResponseEntity.created(location).body(cust1);
	}

	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custService.updateCustomer(customer);
	
	}

	@DeleteMapping("/{customer}")
	public Customer deleteCustomer(@PathVariable Customer customer) {
		return custService.deleteCustomer(customer);
	}

	@GetMapping("/CustomerView/{id}")
	public Customer viewCustomer(@PathVariable(name="id")  int customerId) {
	    return custService.viewCustomer(customerId);
	}

	@GetMapping("/{movieid}")
	public List<Customer> viewAllCustomers(@PathVariable(name="movieid") int movieid) {
		return custService.viewAllCustomers(movieid);
	}
	
}
