package com.SpringProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringProject.Entities.User;

@Service(name="userservice")
public class IUserServiceImpl implements IUserService{
@Autowired
private IUserRepository repo;

@Override
public User addNewUser(User user) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public User signIn(User user) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public User signOut(User user) {
	// TODO Auto-generated method stub
	return null;
}

}
