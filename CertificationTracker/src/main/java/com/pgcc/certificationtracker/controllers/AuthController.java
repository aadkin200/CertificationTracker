package com.pgcc.certificationtracker.controllers;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgcc.certificationtracker.entities.User;
import com.pgcc.certificationtracker.repositories.UserRepository;
import com.pgcc.certificationtracker.security.dto.JwtResponse;
import com.pgcc.certificationtracker.security.dto.LoginRequest;
import com.pgcc.certificationtracker.security.dto.SignupRequest;
import com.pgcc.certificationtracker.security.jwt.JwtUtils;
import com.pgcc.certificationtracker.security.services.UserDetailsImpl;
import com.pgcc.certificationtracker.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;
	  
	  @Autowired
	  UserService userServ;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;

	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		  Optional<User> user = userServ.userByUsername(loginRequest.getUsername());
//		  System.out.println("beginning of signing api================================================================");
//		  System.out.println(loginRequest.getPassword() + " PASSWORD==============================================================");
//		  System.out.println(loginRequest.getUsername() + " USERNAME==============================================================");
	    Authentication authentication = authenticationManager
	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    System.out.println("in signin post mapping---------------------------------------------------------------------");
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	    System.out.println(userDetails.isAdmin() + " ADMIN IN SIGNIN ----------------------------------++++++++++-------");
	    
	    System.out.println(LocalDate.now() + "time-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-==================================----------------");
	    
	    return ResponseEntity.ok(new JwtResponse(jwt,
	            userDetails.getId(),
	            userDetails.getUsername(),
	            userDetails.getEmail(),
	            user.get().isAdmin(),
	            user.get().getRole()));
	  }

	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		  System.out.println(signUpRequest.getUsername() + "Username in Signup Post mapping-------------------1");
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity.badRequest().body("Error: Username is already taken!");
	    }
	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity.badRequest().body("Error: Email is already in use!");
	    }
	    System.out.println(signUpRequest.getUsername() + "Username in Signup Post mapping-------------------2");
	    
	    
	    User user = new User(signUpRequest.getUsername(),
	                         signUpRequest.getEmail(),
	                         signUpRequest.getFirstName(),
	                         signUpRequest.getLastName(),
	                         encoder.encode(signUpRequest.getPassword()));
	    user.setRole("Student");
	    System.out.println(signUpRequest.getUsername() + "Username in Signup Post mapping-------------------3");
	    userRepository.saveAndFlush(user);
	    System.out.println(signUpRequest.getUsername() + "Username in Signup Post mapping-------------------4");
	    System.out.println("--");
	    System.out.println(user.getPassword() + "password in signup Post mapping------------------------------------pass");
	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signUpRequest.getUsername(), signUpRequest.getPassword()));
	    System.out.println(signUpRequest.getUsername() + "Username in Signup Post mapping-------------------5");
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	    System.out.println(user.getUsername() + "Username in SIGNUP --------------------------");
	    System.out.println(user.getPassword() + "password in SIGNUP --------------------------");
	    System.out.println();
	    System.out.println();
	    return ResponseEntity.ok(new JwtResponse(jwt,
	            userDetails.getId(),
	            userDetails.getUsername(),
	            userDetails.getEmail()));
	  }
}
