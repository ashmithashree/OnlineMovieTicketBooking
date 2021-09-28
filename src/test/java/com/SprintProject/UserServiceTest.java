package com.SprintProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.SprintProject.dao.IUserRepository;
import com.SprintProject.entities.Users;
import com.SprintProject.service.IUserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@Mock
	IUserRepository userRepo;
	
	@InjectMocks
	IUserServiceImpl userService;

	@Test
	void addNewUserTest() {
		Users u = new Users(1, "Meera");
		when(userRepo.save(u)).thenReturn(u);
		Users saveUser= userService.addNewUser(u);
		
		assertThat(saveUser).isNotNull();
		assertEquals("Meera", saveUser.getUserName());
		
	}

}
