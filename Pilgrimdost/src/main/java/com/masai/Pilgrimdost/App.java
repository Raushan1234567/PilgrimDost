package com.masai.Pilgrimdost;


import java.time.LocalDate;
import java.util.Scanner;

import com.masai.Pilgrimdost.Dao.Implementation;
import com.masai.Pilgrimdost.Dao.Interface;
import com.masai.Pilgrimdost.Dto.Admin;
import com.masai.Pilgrimdost.Dto.Flight;
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
			
			flight();
			
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
		
	Admin obj=new Admin(name,role,email,password,address,pincode);
		
		Interface obj1=new Implementation();
	
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
		
		
 User obj5=new User(name,role,email,password,address,pincode);
		System.out.println("one");
		Interface obj1=new Implementation();
		System.out.println("ne");
		try {
			obj1.userregister(obj5);
			System.out.println("Registration successful");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	static void flight() {
		Scanner sc=new Scanner(System.in);
		int c=0;
		do {
			
			System.out.println("1. Add Flight Details");
			System.out.println("2. Update Flight Details");
			System.out.println("3. Delete Flight Details");
			System.out.println("4. Find report");
			System.out.println("0. Exit");
			c=sc.nextInt();
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
				System.out.println("Log out successful, Thanks to Visit");
				break;
				default :
					System.out.println("Invalid Selection");
					break;
				
			}
			
			
		}while(c!=0);
	}

	private static void AddFlight(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Flight id");
		String flightid=sc.next();
		System.out.println("Enter Flight Name");
		String flightname=sc.next();
		System.out.println("Enter Flight starting point");
		String flightstartingpoint=sc.next();
		System.out.println("Enter Flight Ending point");
		String flightEndingpointpoint=sc.next();
		System.out.println("Enter Flight Fare per seat");
		double flightfare=sc.nextDouble();
		System.out.println("Enter Flight start date");
		LocalDate flightstartdate=LocalDate.parse(sc.next());
		System.out.println("Enter End date");
		LocalDate flightenddate=LocalDate.parse(sc.next());
		System.out.println("Enter Total seat in flight");
		int totalseat=sc.nextInt();
		System.out.println("Enter available seat in flight");
		int  seatavailable=sc.nextInt();
		System.out.println("Enter journey time in hour");
		String journeytime=sc.next();
		

		
		
		Flight flightobject=new Flight(flightid,flightname,flightstartingpoint,flightEndingpointpoint,
				flightfare,flightstartdate,flightenddate,totalseat,seatavailable,journeytime);
		
		
		Interface referObj=new Implementation();
		
		try {
			referObj.addflight(flightobject);
			System.out.println("Added Successfully");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
	}

	private static void UpdateFlight(Scanner sc) {
		
		System.out.println("Enter Flight id");
		String flightid=sc.next();
		System.out.println("Enter Flight Name");
		String flightname=sc.next();
		System.out.println("Enter Flight starting point");
		String flightstartingpoint=sc.next();
		System.out.println("Enter Flight Ending point");
		String flightEndingpointpoint=sc.next();
		System.out.println("Enter Flight Fare per seat");
		double flightfare=sc.nextDouble();
		System.out.println("Enter Flight start date");
		LocalDate flightstartdate=LocalDate.parse(sc.next());
		System.out.println("Enter End date");
		LocalDate flightenddate=LocalDate.parse(sc.next());
		System.out.println("Enter Total seat in flight");
		int totalseat=sc.nextInt();
		System.out.println("Enter available seat in flight");
		int  seatavailable=sc.nextInt();
		System.out.println("Enter journey time in hour");
		String journeytime=sc.next();
		

		
		
		Flight flightobject=new Flight(flightid,flightname,flightstartingpoint,flightEndingpointpoint,
				flightfare,flightstartdate,flightenddate,totalseat,seatavailable,journeytime);
		
		
		Interface referObj=new Implementation();
		
		try {
			referObj.Updateflight(flightobject);
			System.out.println("Updated Successfully");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	private static void DeleteFlight(Scanner sc) {
		
		System.out.println("Enetr Flight id");
		String flightid=sc.next();
		
		Interface a=new Implementation();
		try {
			a.DelteFlight(flightid);
		  System.out.println("Deleted Successfully"); 
		  
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	private static void flightreport(Scanner sc) {
		
		System.out.println("Enter flight id");
		String flightid=sc.next();
		
		Interface obj10=new Implementation();
		
		try {
			obj10.report(flightid);
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void User(){
		Scanner sc=new Scanner(System.in);
		int c=0;
		do {
			
			System.out.println("1. Add Flight Details");
			System.out.println("2. Update Flight Details");
			System.out.println("3. Delete Flight Details");
			System.out.println("4. Find report");
			System.out.println("0. Exit");
			c=sc.nextInt();
			switch(c) {
			case 1:
				viewflight(sc);
				break;
			case 2:
				SearchFlight(sc);
				break;
			case 3:
			   filter_by_price_rangeanddeparturetime(sc);
				break;
			case 4:
				selectdesireflight(sc);
				break;
				
			case 0:
				System.out.println("Log out successful, Thanks to Visit");
				break;
				default :
					System.out.println("Invalid Selection");
					break;
				
			}
			
			
		}while(c!=0);
	}
}
