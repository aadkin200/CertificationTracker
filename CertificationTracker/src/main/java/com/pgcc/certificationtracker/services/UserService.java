package com.pgcc.certificationtracker.services;

import java.util.List;

import com.pgcc.certificationtracker.entities.User;

public interface UserService {
	User userByUsername(String username);
	List<User>getAllUsers();

}
