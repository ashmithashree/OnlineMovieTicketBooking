package com.SpringProject.Service;

import com.SpringProject.Entities.User;

public interface IUserService {
	public abstract User addNewUser(User user);
	public abstract User signIn(User user);
	public abstract User signOut(User user);
}
