package com.masai.Pilgrimdost;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.Pilgrimdost.Dao.Implementation;
import com.masai.Pilgrimdost.Dao.Interface;
import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.User;
import com.masai.Pilgrimdost.exception.SomeThingWentWrong;

public class App 
{
   public static void main( String[] args )
    {
      Scanner sc=new Scanner(System.in);
      
      int c;
      do {
    	  System.out.println("1. For admin resgistration press-1");
    	  System.out.println("2. For  user Signup press-2");
    	  System.out.println("3. For admin login press-3");
    	  System.out.println("4. For  user login press-4");
    	  System.out.println("0. Exit");
    	  
    	  c=sc.nextInt();
    	  
    	  switch(c) {
    	  case 1:
    		  adminregister(sc);
    		  break;
    	  case 2:
    		  userregister(sc);
    		  break;
    	  case 3:
    		  adminlogin(sc);
    		  break;
    	  case 4:
    		  userlogin(sc);
    		  break;
    	  case 0:
    		  System.out.println("Thanks for Visit");
    		  break;
    		  default :
    			  System.out.println("Invalid selection");
    		  
    	  }
    	  
      }while(c!=0);
      sc.close();
    }

	private static void adminlogin(Scanner sc) {
	
		
		System.out.println("Eneter email");
		String email=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		
		Interface obj3=new Implementation();
		try {
			obj3.adminlogin1(email,pass);
			System.out.println("login Success");
			flight(sc);
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

	private static void userlogin(Scanner sc) {
		System.out.println("Eneter email");
		String email=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		
		Interface obj3=new Implementation();
		obj3.userlogin1(email,pass);
	
}

	private static void adminregister(Scanner sc) {
		
		
		System.out.println(" Enter name");
		String name=sc.next();
		System.out.println(" Enter email");
		String email=sc.next();
		System.out.println(" Enter Password");
		String password=sc.next();
		System.out.println(" Enter Addrress");
		String address=sc.next();
		System.out.println(" Enter pincode");
		String pincode=sc.next();
		System.out.println(" Enter role");
		String role=sc.next();
		
	Admin obj=new Admin(name,email,password,address,pincode,role);
		System.out.println("one");
		Interface obj1=new Implementation();
		System.out.println("ne");
		obj1.adminregister(obj);
	}

	private static void userregister(Scanner sc) {
		
		System.out.println(" Enter name");
		String name=sc.next();
		System.out.println(" Enter role");
		
		String role=sc.next();
		System.out.println(" Enter email");
		String email=sc.next();
		System.out.println(" Enter Password");
		String password=sc.next();
		System.out.println(" Enter Addrress");
		String address=sc.next();
		
		
		
		System.out.println(" Enter pincode");
		String pincode=sc.next();
		
		
 User obj=new User(name,role,email,password,address,pincode);
		System.out.println("one");
		Interface obj1=new Implementation();
		System.out.println("ne");
		try {
			obj1.userregister(obj);
			System.out.println("Registration successful");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	static void flight(Scanner sc) {
		int c=0;
		do {
			c=sc.nextInt();
			System.out.println("1. Add Flight Details");
			System.out.println("2. Update Flight Details");
			System.out.println("3. Delete Flight Details");
			System.out.println("4. Find report");
			System.out.println("0. Exit");
			
			switch(c) {
			case 1:
				AddFlight(sc);
				break;
			case 2:
				UpdateFlight(sc);
				break;
			case 3:
			   DeleteFlight(sc);
				break;
			case 4:
				flightreport(sc);
				break;
			case 0:
				System.out.println("Thanks to Visit");
				break;
				default :
					System.out.println("Invalid Selection");
					break;
				
			}
			
			
		}while(c!=0);
	}

	private static void AddFlight(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void UpdateFlight(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void DeleteFlight(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	private static void flightreport(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
}
