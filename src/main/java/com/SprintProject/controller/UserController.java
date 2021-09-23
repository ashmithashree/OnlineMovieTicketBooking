package com.SprintProject.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.entities.Users;
import com.SprintProject.service.IUserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserServiceImpl userService;
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Users> addNewUser(@Valid @RequestBody Users user) {
		Users user1=userService.addNewUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user1.getUserId())
				.toUri();
		return ResponseEntity.created(location).body(user1);
	}
	
	
	public Users signIn(Users user) {
		return userService.signIn(user);
	}

	
	public Users signOut(Users user) {
		return userService.signOut(user);
	}

}