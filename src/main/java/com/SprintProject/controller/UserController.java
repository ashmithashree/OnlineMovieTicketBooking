package com.SprintProject.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SprintProject.dao.IUserRepository;
import com.SprintProject.dao.RoleRepository;
import com.SprintProject.entities.Role;
import com.SprintProject.entities.Roles;
import com.SprintProject.entities.Users;
import com.SprintProject.model.SignUp;
import com.SprintProject.service.IUserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserServiceImpl userService;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
//	@PostMapping("/user")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Users> addNewUser(@Valid @RequestBody Users user) {
//		Users user1=userService.addNewUser(user);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(user1.getUserId())
//				.toUri();
//		return ResponseEntity.created(location).body(user1);
//	}
//	
	
	public Users signIn(Users user) {
		return userService.signIn(user);
	}

	
	public Users signOut(Users user) {
		return userService.signOut(user);
	}
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody SignUp signupRequest) {
		if(userRepository.existsByUserName(signupRequest.getUserName())){
	      return ResponseEntity.badRequest().body("Username is already taken");
	    }
	   
	    Users user = new Users();
	    Set<Role> roles = new HashSet<>();
	    user.setUserName(signupRequest.getUserName());
	    user.setPassword(encoder.encode(signupRequest.getPassword()));
	    System.out.println("Encoded password--- " + user.getPassword());
	    String[] roleArr = signupRequest.getRoles();
	    for(String s:roleArr)
	    {
	    	System.out.println(s);
	    }
	    if(roleArr == null) {
	      roles.add(roleRepository.findByRoleName(Roles.ROLE_USER).get());
	    }
	    for(String role: roleArr) {
	      switch(role) {
	        case "admin":
	          roles.add(roleRepository.findByRoleName(Roles.ROLE_ADMIN).get());
	          break;
	        case "user":
	          roles.add(roleRepository.findByRoleName(Roles.ROLE_USER).get());
	          break;  
	        default:
	          return ResponseEntity.badRequest().body("Specified role not found");
	      }
	    }
	    user.setRoles(roles);
	    userService.addNewUser(user);
	    return ResponseEntity.ok("User signed up successfully");
	}
}