package com.pgcc.certificationtracker.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Column(unique=true)
	private String username;
	@JsonIgnore
	@NotBlank
	@Column(unique=true)
	private String password;
	@NotBlank
	@Column(unique=true)
	private String email;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private boolean admin;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	@OneToMany(mappedBy="user")
	private List<Certification> certifications;
	private boolean active;
	private String role;
	
	
	
	
	public User() {}
	
	
	
	
	  public User(@NotBlank String username, @NotBlank String email, String firstName, String lastName,
			@NotBlank String password) {
		super();
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}




	public User(String username, String email, String password) {
		    this.username = username;
		    this.email = email;
		    this.password = password;
		  }
	
	public User(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public User(int id, String username, String password, String email, String firstName, String lastName,
			boolean admin, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = admin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public User(int id, String username, String password, String email, String firstName, String lastName,
			boolean admin, LocalDateTime createdAt, LocalDateTime updatedAt, List<Certification> certifications) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = admin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.certifications = certifications;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certification) {
		this.certifications = certification;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", admin=" + admin + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}

