package com.masai.Pilgrimdost.Dao;


import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.Flight;
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
	}else {
		
		System.out.println("Welcome "+  result.getName()+" in "+ "PilgrimDost");
	}
			
		}catch( NoResultException e) {
			System.out.println(e);
		}
		
	finally {
	em.close();
	}
	
		
	}

	@Override
	public void userregister(User obj5) throws SomeThingWentWrong {
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
	
EntityTransaction et=em.getTransaction();

et.begin();
em.persist(obj5);
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

	@Override
	public void addflight(Flight flightobject) throws SomeThingWentWrong {
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
	
EntityTransaction et=em.getTransaction();

et.begin();
em.persist(flightobject);
et.commit();	
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Some thing went wrong");
		}
		
	finally {
	em.close();
	}
		
	}

	@Override
	public void report(String flightid) throws SomeThingWentWrong {
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
	

String Q="select e from Flight e where flightid=:a";

Query qu=em.createQuery(Q);
qu.setParameter("a", flightid);
Flight var=(Flight) qu.getSingleResult();
int var1=var.getTotalseat() - var.getAvailableseat();
double totalrevenue=var1*var.getPrice();

double percentageofused =(var1*100)/var.getTotalseat();
System.out.println("report of flight "+flightid);
System.out.println();
System.out.println("Total revenue is "+totalrevenue);
System.out.println("Seat has Booked "+percentageofused+"%");
	
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Some thing went wrong");
		}
		
	finally {
	em.close();
	}
		
	}

	@Override
	public void DelteFlight(String flightid) throws SomeThingWentWrong {
		
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
		
		Flight t=em.find(Flight.class, flightid);
	if(t==null) {
		
		
	}
	else {
EntityTransaction et=em.getTransaction();

et.begin();
em.remove(t);
et.commit();	}
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("No record found");
		}
		
	finally {
	em.close();
	}
		
	}

	@Override
	public void Updateflight(Flight flightobject) throws SomeThingWentWrong {
		EntityManager em=null;
		try {
			
		em=Connect.getconnection();
		
		Flight t=em.find(Flight.class,flightobject.getFlightid());
	if(t==null) {
		
		
	}
	else {
EntityTransaction et=em.getTransaction();

et.begin();
em.merge(flightobject);
et.commit();	}
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("No record found");
		}
		
	finally {
	em.close();
	}
		
	}

}
