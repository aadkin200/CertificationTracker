package com.pgcc.certificationtracker.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgcc.certificationtracker.entities.Certification;
import com.pgcc.certificationtracker.services.CertificationService;


@RestController
@RequestMapping("/api/private/certification")
@CrossOrigin({"*", "http://localhost"})
public class CertificationController {
	
	@Autowired
	private CertificationService certServ;
	
	
	@GetMapping("/certs")
	public List<Certification> index() {
		return certServ.getAllCerts();
	}
	
	@GetMapping("/certs/{username}")
	public List<Certification> getCertificationByUsername(@PathVariable("username") String username, Principal principal) {
		
		return null;
	}
	
	@PostMapping("/certs/{username}")
	public Certification addCertification(@PathVariable("username") String username, @RequestBody Certification cert,  Principal principal) {
		Certification newCert = certServ.create(username, cert);
		return newCert;
	}
	
	@PutMapping("/cert/")
	public boolean deleteCertification(@RequestBody Certification cert) {
		return certServ.destroy(cert.getId());
	}
	
	@PutMapping("/cert/cert")
	public Certification updateCertification(@RequestBody Certification cert) {
		System.out.println("update cert method----------------" + cert.getDateObtained());
		return certServ.update(cert);
	}

}
