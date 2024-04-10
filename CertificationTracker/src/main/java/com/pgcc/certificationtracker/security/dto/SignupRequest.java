package com.pgcc.certificationtracker.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupRequest {
	  @NotBlank
	  @Size(min = 3, max = 20)
	  private String username;
	  @NotBlank
	  private String firstName;
	  @NotBlank
	  private String lastName;
	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;
	  @NotBlank
	  @Size(min = 6, max = 40)
	  private String password;

	  
	  
	  
	  public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	}
