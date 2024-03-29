package com.pgcc.certificationtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgcc.certificationtracker.entities.User;
import com.pgcc.certificationtracker.services.UserService;

@RestController
@RequestMapping("/api/")
@CrossOrigin({"*", "http://localhost"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User>getAllUsers() {
		return userService.getAllUsers();
	}

}
