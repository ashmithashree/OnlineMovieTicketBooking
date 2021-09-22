package com.SprintProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SprintProject.dao.IUserRepository;
import com.SprintProject.entities.Users;
@Service(value="IUserService")
public class IUserServiceImpl implements IUserService{
	@Autowired
    IUserRepository repository;
	
	@Override
	public Users addNewUser(Users user) {
		return repository.save(user);
	}

	@Override
	public Users signIn(Users user) {
		//return repository.save(user);
		return null;
	}
	@Override
	public Users signOut(Users user) {
		//return repository.save(user);
		return null;
	}
}