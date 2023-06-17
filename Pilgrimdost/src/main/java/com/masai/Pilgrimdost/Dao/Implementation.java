package com.masai.Pilgrimdost.Dao;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.Booking;
import com.masai.Pilgrimdost.Dto.Flight;
import com.masai.Pilgrimdost.Dto.User;
import com.masai.Pilgrimdost.exception.SomeThingWentWrong;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

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
	public int userlogin1(String email, String pass) throws SomeThingWentWrong {
		EntityManager em=null;
		int Uid=0;
		try {
			
		em=Connect.getconnection();
		
		String q="select e from User e where password =:a and email =:b";
		
	Query query=em.createQuery(q);
	query.setParameter("a", pass);
	query.setParameter("b", email);
	
	User result= (User) query.getSingleResult();
	Uid=result.getUserid();
	if(result!=null) {
		System.out.println("Welcome"+"  "+ result.getName() +" "+"in"+" "+ "PilgrimDost");

	}
			
		}catch( NoResultException e) {
			throw new SomeThingWentWrong("User not Exists");
		}
		
	finally {
	em.close();
	}
	return Uid;	
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

	@Override
	public List<Flight> view_flight() throws SomeThingWentWrong {
		
		EntityManager em=null;
		List<Flight> list=new ArrayList<>();
		try {
			
		em=Connect.getconnection();
		
		String query="select e from Flight e ";
		
		Query executequery=em.createQuery(query);
		
		list=executequery.getResultList();
		
		
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Some thing went wrong");
		}
		
	finally {
	em.close();
	}
		
		
		return list;
	}

	@Override
	public List<Flight> serch(String departure_city_name, String destination, int passenger_count, LocalDate d1) throws SomeThingWentWrong {
		EntityManager em=null;
		List<Flight> list=null;
		try {
			
		em=Connect.getconnection();
		
		String query="select e from Flight e where StartingPoint =:a and EndingPoint =:b and availableseat >= :c and Startdate >=:d";
		
		Query executequery=em.createQuery(query);
		executequery.setParameter("a", departure_city_name);
		executequery.setParameter("b", destination);
		executequery.setParameter("c", passenger_count);
		executequery.setParameter("d", d1);
	
		list=executequery.getResultList();
		
		
		if(list.size()<=0) {
			
			throw new SomeThingWentWrong("Flight not available");
			
		}
		
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Some thing went wrong");
		}
		
	finally {
	em.close();
	}
		
		
		return list;
	}

	@Override
	public Flight Select(String fligth_id) throws SomeThingWentWrong {
		EntityManager em=null;
		Flight d=null;
		try {
			
		em=Connect.getconnection();
		
		String query="select e from Flight e where flightid =:a";
		
		Query executequery=em.createQuery(query);
		executequery.setParameter("a", fligth_id);
		
		
		d=(Flight) executequery.getSingleResult();
		
		
	
		
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Flight not available");
		}
		
	finally {
	em.close();
	}
		
		
		return d;
	}

	@Override
	public double book1(String flightid,String name, String adharno, int noofseat, String mobileno,int uId) throws SomeThingWentWrong {
		
		EntityManager em=null;
	double p=0;
		try {
			
		em=Connect.getconnection();
		
		Flight t=em.find(Flight.class, flightid);
		User u=em.find(User.class, uId);
		
		Booking obj=new Booking(name,noofseat,mobileno,adharno,t,u);
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(obj);
		t.setAvailableseat(t.getAvailableseat()-noofseat);
		et.commit();
	p=t.getPrice();
		
	
		
		}catch(Exception e) {
			
		   throw new SomeThingWentWrong("Flight not available");
		}
		
	finally {
	em.close();
	}
	return p;	
		
	}

}
