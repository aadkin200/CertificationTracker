package com.pgcc.certificationtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgcc.certificationtracker.entities.Certification;


@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer>{

	List<Certification> findByUser_Username(String username);
	
}
