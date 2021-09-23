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
	private Set<TicketBooking> ticketId =new HashSet<>();
	
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
	public Set<TicketBooking> getTicketId() {
		return ticketId;
	}
	public void setTicketId(Set<TicketBooking> ticketId) {
		this.ticketId = ticketId;
		for(TicketBooking tx:ticketId)
		{
			tx.setCustomer(this);
		}
	}

}
