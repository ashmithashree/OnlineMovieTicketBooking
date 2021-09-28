package com.SprintProject;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.SprintProject.dao.ICustomerRepository;
import com.SprintProject.entities.Customer;
import com.SprintProject.service.ICustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
	@Mock
	ICustomerRepository custRepo;
	
	@InjectMocks
	ICustomerServiceImpl custService;


	@Test
	void addCustomerTest() {
		Customer c = new Customer(1,"Meera","Chennai","12345","abc@gmail.com","abc123");
		when(custRepo.save(c)).thenReturn(c);
		Customer saveCust= custService.addCustomer(c);
		
		assertThat(saveCust).isNotNull();
		assertEquals("Meera", saveCust.getCustomerName());
	}
	
	@Test
	void testDelete() {
		custRepo.deleteById(1);
		assertThat(custRepo.existsById(1)).isFalse();
	}


}
