package com.pgcc.certificationtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgcc.certificationtracker.entities.Certification;
import com.pgcc.certificationtracker.repositories.CertificationRepository;
import com.pgcc.certificationtracker.repositories.UserRepository;

@Service
public class CertificationServiceImpl implements CertificationService{
	
	@Autowired
	CertificationRepository certRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Certification>getCertsByUsername(String username) {
		return certRepo.findByUser_Username(username);
	}

	@Override
	public List<Certification> getAllCerts() {
		return certRepo.findAll();
	}

	@Override
	public List<Certification> getCertsById(int id) {
		return certRepo.findByUser_Id(id);
	}

	@Override
	public Certification create(String username, Certification cert) {
		cert.setUser(userRepo.findByUsername(username).get());
		return certRepo.saveAndFlush(cert);
	}

	@Override
	public Certification update(Certification cert) {
		System.out.println("update cert within serviceimpl----------------------" + cert.getDateObtained());
		Certification managedCert = certRepo.findById(cert.getId()).get();
		System.out.println("update cert within serviceimpl managed cert----------" + cert.getDateObtained());
		if(managedCert != null) {
			managedCert.setDateExpiration(cert.getDateExpiration());
			managedCert.setDateObtained(cert.getDateObtained());
			managedCert.setName(cert.getName());
			managedCert.setCompany(cert.getCompany());
			return certRepo.saveAndFlush(managedCert);
		}
		return managedCert;
	}

	@Override
	public boolean destroy(int certId) {
		Certification managedCert = certRepo.findById(certId).get();
		if(managedCert != null) {
			certRepo.delete(managedCert);
			return true;
		}
		return false;
	}

}
