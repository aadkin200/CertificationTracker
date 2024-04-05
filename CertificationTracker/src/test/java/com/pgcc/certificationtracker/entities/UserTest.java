package com.pgcc.certificationtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("CertificationTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName("user entity test")
	void test() {
		assertNotNull(user);
		assertEquals("zone", user.getUsername());
	}
	
	@Test
	@DisplayName("tests password")
	void test1() {
		assertNotNull(user);
		assertEquals("Daush@1115", user.getPassword());
	}
	
	@Test
	@DisplayName("user all certs")
	void test2() {
		assertNotNull(user);
		assertEquals("A+ CE", user.getCertification().get(1).getName());
		assertEquals("Security+ CE", user.getCertification().get(0).getName());
	}

}
