package com.SprintProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SprintProject.dao.IUserRepository;
import com.SprintProject.entities.Users;
@Service(value="IUserService")
@Transactional(readOnly=true)
public class IUserServiceImpl implements IUserService{
	@Autowired
    IUserRepository repository;
	
	@Override
	@Transactional
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