package com.cetpa.admin.repository;

import java.util.List;

import com.cetpa.entity.User;

public interface UserRepository
{
	List<User> getUserList();
	void createAccount(User user);
	User getUser(String uid);
	void deleteUser(User user);	
}
