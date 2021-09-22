package com.SprintProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.SprintProject.dao.IUserRepository;
import com.SprintProject.entities.User;

public class IUserServiceImpl implements IUserService{
	@Autowired
    IUserRepository repository;
	
	@Override
	public User addNewUser(User user) {
		return ((IUserRepository) repository).save(user);
	}

	@Override
	public User signIn(User user) {
		return repository.save(user);
	}

	@Override
	public User signOut(User user) {
		return repository.save(user);
	}
}
