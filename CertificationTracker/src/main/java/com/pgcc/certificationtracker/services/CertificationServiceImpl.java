package com.pgcc.certificationtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgcc.certificationtracker.entities.Certification;
import com.pgcc.certificationtracker.repositories.CertificationRepository;

@Service
public class CertificationServiceImpl implements CertificationService{
	
	@Autowired
	CertificationRepository certRepo;
	
	public List<Certification>getCertsByUsername(String username) {
		return certRepo.findByUser_Username(username);
	}

	@Override
	public List<Certification> getAllCerts() {
		return certRepo.findAll();
	}

}
