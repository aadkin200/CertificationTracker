package com.pgcc.certificationtracker.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgcc.certificationtracker.entities.User;
import com.pgcc.certificationtracker.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Optional<User> userByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> updateUser(User user, String username) {
		Optional<User> managedUser;
		User flushUser;
		try {
			managedUser = userRepo.findByUsername(username);
			if(user.getId() == managedUser.get().getId()) {
				managedUser.get().setEmail(user.getEmail());
				managedUser.get().setFirstName(user.getFirstName());
				managedUser.get().setLastName(user.getLastName());
				managedUser.get().setUpdatedAt(LocalDate.now());
				managedUser.get().setRole(user.getRole());
			}
			userRepo.saveAndFlush(managedUser.get());
			
		} catch (Exception e) {
			managedUser = null;
		}
		return managedUser;
	}

	@Override
	public boolean disableUser(int userId, String username) {
		try {
			Optional<User> admin = userRepo.findByUsername(username);
			if(admin.get().getRole().equalsIgnoreCase("admin")) {
				Optional<User> user = userRepo.findById(userId);
				if(user.isPresent()) {
					user.get().setActive(false);
					userRepo.saveAndFlush(user.get());
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean userEnable(int userId, String username) {
		try {
			Optional<User> admin = userRepo.findByUsername(username);
			if(admin.get().getRole().equalsIgnoreCase("admin")) {
				Optional<User> user = userRepo.findById(userId);
				if(user.isPresent()) {
					user.get().setActive(true);
					userRepo.saveAndFlush(user.get());
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

}
