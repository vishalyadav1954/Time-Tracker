package com.cetpa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.User;
import com.cetpa.admin.repository.UserRepository;
import com.cetpa.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired private UserRepository userRepository;

	public List<User> getList() 
	{
		return userRepository.getUserList();
	}
	public boolean createUserAccount(User user) 
	{
		User userdb=userRepository.getUser(user.getUserid()); 
		if(userdb!=null)
			return false;
		userRepository.createAccount(user);
		return true;
	}
	public void deleteUser(String uid) 
	{
		User user=userRepository.getUser(uid);
		userRepository.deleteUser(user);
	}
	public User getUserById(String userid) 
	{
		return userRepository.getUser(userid);
	}
}
