package com.pgcc.certificationtracker.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgcc.certificationtracker.entities.Certification;
import com.pgcc.certificationtracker.services.CertificationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user/certification/")
@CrossOrigin({"*", "http://localhost"})
public class CertificationController {
	
	@Autowired
	private CertificationService certServ;
	
	@GetMapping("cert/")
	public List<Certification> index(HttpServletRequest req,
									 HttpServletResponse res,
									 Principal principal) {
		return certServ.getAllCerts();
	}

}
