package com.SprintProject.service;

import com.SprintProject.entities.Users;

public interface IUserService {
	public abstract Users addNewUser(Users user);
	public abstract Users signIn(Users user);
	public abstract Users signOut(Users user);

}