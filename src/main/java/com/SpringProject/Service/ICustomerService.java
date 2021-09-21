package com.SpringProject.Service;

import java.util.List;

import com.SpringProject.Entities.Customer;

public interface ICustomerService {
	public abstract Customer addCustomer(Customer customer);
	public abstract Customer updateCustomer(Customer customer);
	public abstract Customer delectCustomer(Customer customer);
	public abstract Customer viewCustomer(int custid);
	public abstract List<Customer> viewAllCustomer(int movieid);
}
