package com.SprintProject.service;

import com.SprintProject.entities.User;

public interface IUserService {
	public abstract User addNewUser(User user);
	public abstract User signIn(User user);
	public abstract User signOut(User user);

}