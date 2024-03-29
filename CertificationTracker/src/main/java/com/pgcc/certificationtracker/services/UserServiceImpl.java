package com.pgcc.certificationtracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pgcc.certificationtracker.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserService userService;

	@Override
	public User userByUsername(String username) {
		return userService.userByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
