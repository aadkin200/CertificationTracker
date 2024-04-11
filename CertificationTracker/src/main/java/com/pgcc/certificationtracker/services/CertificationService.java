package com.pgcc.certificationtracker.services;

import java.util.List;

import com.pgcc.certificationtracker.entities.Certification;

public interface CertificationService {
	
	public List<Certification>getCertsByUsername(String username);
	public List<Certification> getAllCerts();
	public List<Certification>getCertsById(int id);
	public Certification create(String username, Certification cert);
	public Certification update(Certification cert);
	public boolean destroy(int trailId);

}
