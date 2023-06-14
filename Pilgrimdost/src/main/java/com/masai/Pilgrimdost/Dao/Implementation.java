package com.masai.Pilgrimdost.Dao;

import java.sql.SQLException;



import com.masai.Pilgrimdost.Dto.Admin;

import jakarta.persistence.*;
import jakarta.persistence.EntityTransaction;

public class Implementation implements Interface{

	@Override
	public void adminregister(Admin obj) {
		
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
		System.out.println("wone");
EntityTransaction et=em.getTransaction();

et.begin();
em.persist(obj);
et.commit();	
		}catch(PersistenceException | IllegalStateException | IllegalArgumentException e) {
			System.out.println(e);
		}
		
	finally {
	em.close();
	}
	
		
	}

	@Override
	public void adminlogin1(String email, String pass) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
		
		String q="select e from Admin e where password =:a and email =:b";
		
	Query query=em.createQuery(q);
	query.setParameter("a", pass);
	query.setParameter("b", email);
	
	Admin result=(Admin) query.getSingleResult();
	if(result!=null) {
	System.out.println("Login succesas");
	
	}
			
		}catch( NoResultException e) {
			System.out.println(e);
		}
		
	finally {
	em.close();
	}
	
		
	}

}
