package com.masai.Pilgrimdost.Dao;



import java.time.LocalDate;
import java.util.List;

import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.Flight;
import com.masai.Pilgrimdost.Dto.User;
import com.masai.Pilgrimdost.exception.SomeThingWentWrong;

public interface Interface {

	void adminregister(Admin obj, String name);

	

	void adminlogin1(String email, String pass) throws SomeThingWentWrong;



	void userregister(User obj5) throws SomeThingWentWrong;



	int userlogin1(String email, String pass) throws SomeThingWentWrong;



	void addflight(Flight flightobject) throws SomeThingWentWrong;



	void report(String flightid) throws SomeThingWentWrong;



	void DelteFlight(String flightid) throws SomeThingWentWrong;



	void Updateflight(Flight flightobject) throws SomeThingWentWrong;



	List<Flight> view_flight() throws SomeThingWentWrong;



	List<Flight> serch(String departure_city_name, String destination, int passenger_count, LocalDate d) throws SomeThingWentWrong;



	Flight Select(String fligth_id) throws SomeThingWentWrong;



	double book1( String flightid,String name, String adharno, int noofseat, String mobileno, int uId ) throws SomeThingWentWrong;



	void see_booking_details(int uId) throws SomeThingWentWrong;



	List<Flight> Filter_by_price(double min_price, double max_price) throws SomeThingWentWrong;



	void Cancel_Ticket(int booking_id) throws SomeThingWentWrong;



	



	

	
	
}
