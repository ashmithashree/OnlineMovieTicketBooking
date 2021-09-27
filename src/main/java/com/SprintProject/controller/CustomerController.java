package com.SprintProject.controller;
import org.springframework.http.HttpStatus;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		Customer cust1 = custService.addCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cust1.getCustomerId())
				.toUri();
		return ResponseEntity.created(location).body(cust1);
	}

	
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		Customer cust=custService.updateCustomer(customer);
		return ResponseEntity.accepted().body(cust + " Updated Successfully \uD83D\uDE00");
	
	}
	
	@DeleteMapping("/{customer}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
		Customer custdelete= custService.deleteCustomer(customer);
		return ResponseEntity.ok().body(custdelete.getCustomerId() + " Customer deleted. Oh! We miss You \uD83D\uDE15" );
	}
	
	@GetMapping("/CustomerView/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Customer viewCustomer(@PathVariable(name="id")  int customerId) {
		Customer cust= custService.viewCustomer(customerId);
		return cust;
	}
	@GetMapping("/{movieid}")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Customer> viewAllCustomers(@PathVariable(name="movieid") int movieid) {
		List<Customer> allcust=custService.viewAllCustomers(movieid);
		return allcust;
	}
}
