package com.pgcc.certificationtracker.services;

import java.util.List;
import java.util.Optional;

import com.pgcc.certificationtracker.entities.User;

public interface UserService {
	Optional<User> userByUsername(String username);
	List<User>getAllUsers();
	Optional<User> updateUser(User user, String username);
	boolean disableUser(int userId, String username);
	boolean userEnable(int userId, String username);

}
