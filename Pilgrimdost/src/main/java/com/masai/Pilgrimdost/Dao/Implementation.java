package com.masai.Pilgrimdost.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.masai.Pilgrimdost.App;
import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.User;
import com.masai.Pilgrimdost.exception.SomeThingWentWrong;

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
	public void adminlogin1(String email, String pass) throws SomeThingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
		
		String q="select e from Admin e where password =:a and email =:b";
		
	Query query=em.createQuery(q);
	query.setParameter("a", pass);
	query.setParameter("b", email);
	
	Admin result=(Admin) query.getSingleResult();
	if(result==null) {
		throw new SomeThingWentWrong("Id not found");
	}
			
		}catch( NoResultException e) {
			System.out.println(e);
		}
		
	finally {
	em.close();
	}
	
		
	}

	@Override
	public void userregister(User obj) throws SomeThingWentWrong {
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
	
EntityTransaction et=em.getTransaction();

et.begin();
em.persist(obj);
et.commit();	
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Some thing went wron");
		}
		
	finally {
	em.close();
	}
		
	}

	@Override
	public void userlogin1(String email, String pass) {
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
		
		String q="select e from User e where password =:a and email =:b";
		
	Query query=em.createQuery(q);
	query.setParameter("a", pass);
	query.setParameter("b", email);
	
	List<User> result=(List<User>) query.getResultList();
	if(result!=null) {
		result.forEach(d -> System.out.println("Welcome"+"  "+ d.getName() +" "+"in"+" "+ "PilgrimDost"));

	}
			
		}catch( NoResultException e) {
			System.out.println(e);
		}
		
	finally {
	em.close();
	}
		
	}

}
