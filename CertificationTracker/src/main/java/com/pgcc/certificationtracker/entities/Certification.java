package com.pgcc.certificationtracker.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Certification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnore
	@ManyToOne
	private User user;
	private String company;
	private String name;
	@Column(name="date_obtained")
	private LocalDateTime dateObtained;
	@Column(name="date_expiration")
	private LocalDateTime dateExpiration;
	
	
	
	
	public Certification() {}
	
	public Certification(int id, User user, String company, String name, LocalDateTime dateObtained,
			LocalDateTime dateExpiration) {
		this.id = id;
		this.user = user;
		this.company = company;
		this.name = name;
		this.dateObtained = dateObtained;
		this.dateExpiration = dateExpiration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getDateObtained() {
		return dateObtained;
	}
	public void setDateObtained(LocalDateTime dateObtained) {
		this.dateObtained = dateObtained;
	}
	public LocalDateTime getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDateTime dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	@Override
	public String toString() {
		return "Certification [id=" + id + ", user=" + user + ", company=" + company + ", name=" + name
				+ ", dateObtained=" + dateObtained + ", dateExpiration=" + dateExpiration + "]";
	}

}

