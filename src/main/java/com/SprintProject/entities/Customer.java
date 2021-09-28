package com.SprintProject.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name="onlinecustomer")
@Table(name="onlinecustomer")
public class Customer {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int customerId;
	@Column(name="name")
	private String customerName;
	private String address;
	private String mobileNumber;
	private String email;
	private String password;
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private Set<TicketBooking> ticket=new HashSet<>();
	
	
	public Customer(int customerId, String customerName, String address, String mobileNumber, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<TicketBooking> getTicket() {
		return ticket;
	}
	public void setTicket(Set<TicketBooking> ticket) {
		this.ticket = ticket;
		for(TicketBooking tx:ticket)
		{
			tx.setCustomer(this);
		}
	}
	
}