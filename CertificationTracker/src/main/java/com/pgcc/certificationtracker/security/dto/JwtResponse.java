package com.pgcc.certificationtracker.security.dto;

public class JwtResponse {
	  private String token;
	  private String type = "Bearer";
	  private int id;
	  private String username;
	  private String email;
	  private boolean admin;
	  private String role;

	  public JwtResponse(String accessToken, int id, String username, String email) {
	    this.token = accessToken;
	    this.id = id;
	    this.username = username;
	    this.email = email;

	  }
	  
	  public JwtResponse(String accessToken, int id, String username, String email, boolean admin, String role) {
		  this.token = accessToken;
		    this.id = id;
		    this.username = username;
		    this.email = email;
		    this.admin = admin;
		    this.role = role;
		  
	  }

	  public String getAccessToken() {
	    return token;
	  }

	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }

	  public String getTokenType() {
	    return type;
	  }

	  public void setTokenType(String tokenType) {
	    this.type = tokenType;
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	  
	  

	}
