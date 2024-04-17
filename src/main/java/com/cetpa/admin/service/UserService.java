package com.cetpa.admin.service;

import java.util.List;

import com.cetpa.entity.User;

public interface UserService 
{
	List<User> getList();
	boolean createUserAccount(User user);
	void deleteUser(String uid);
	User getUserById(String userid);
}
