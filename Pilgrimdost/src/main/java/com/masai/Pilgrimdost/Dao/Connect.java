package com.masai.Pilgrimdost.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connect {

	static EntityManagerFactory emf;
	static {
	
		emf=Persistence.createEntityManagerFactory("connect");
	}
	
	 static EntityManager getconnection() {
		 
		return emf.createEntityManager();
	}
	
}
