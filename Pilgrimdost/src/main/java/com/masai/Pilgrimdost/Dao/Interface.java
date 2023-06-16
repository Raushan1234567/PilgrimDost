package com.masai.Pilgrimdost.Dao;



import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.User;
import com.masai.Pilgrimdost.exception.SomeThingWentWrong;

public interface Interface {

	void adminregister(Admin obj);

	

	void adminlogin1(String email, String pass) throws SomeThingWentWrong;



	void userregister(User obj) throws SomeThingWentWrong;



	void userlogin1(String email, String pass);

	
	
}
