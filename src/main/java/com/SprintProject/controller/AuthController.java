package com.SprintProject.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SprintProject.dao.IUserRepository;
import com.SprintProject.entities.Users;
import com.SprintProject.dao.RoleRepository;
import com.SprintProject.entities.Role;
import com.SprintProject.entities.Roles;
import com.SprintProject.model.SignUp;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	IUserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	
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
	    user.setRole(roles);
	    userRepository.save(user);
	    return ResponseEntity.ok("User signed up successfully");
	}
}
