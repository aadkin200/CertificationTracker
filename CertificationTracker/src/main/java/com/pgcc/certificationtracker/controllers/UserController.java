package com.pgcc.certificationtracker.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgcc.certificationtracker.entities.User;
import com.pgcc.certificationtracker.services.UserService;

@RestController
@RequestMapping("/api/private")
@CrossOrigin({"*", "http://localhost"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User>getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable("username") String username, Principal principal) {
		System.out.println(principal.getName() + "----------------------------------------------");
		Optional<User> user = userService.userByUsername(principal.getName());
		System.out.println(user.get().getFirstName() + " first name -----------------------------------");
		
		return user.get();
	}

}
