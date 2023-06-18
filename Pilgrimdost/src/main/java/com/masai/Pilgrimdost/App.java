package com.masai.Pilgrimdost;


import java.time.LocalDate;
import java.util.List;
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
		try {
			int uId=obj3.userlogin1(email,pass);
			User(uId);
			
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	
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
	static void User(int uId){
		Scanner sc=new Scanner(System.in);
		int c=0;
		do {
			
			System.out.println("1. View Flight Details");
			System.out.println("2. Search Flight Details");
			System.out.println("3. Filter by price");
			System.out.println("4. Select desire flight");
			System.out.println("5. See Booked tickets");
			System.out.println("0. Logout");
			c=sc.nextInt();
			switch(c) {
			case 1:
				viewflight();
				break;
			case 2:
				SearchFlight(sc);
				break;
			case 3:
			   filter_by_price_rangeanddeparturetime(sc);
				break;
			case 4:
				selectdesireflight(sc,uId);
				break;
			case 5:
				BookingDetails(sc,uId);
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

	private static void BookingDetails(Scanner sc, int uId) {
	
		
		
		Interface a=new Implementation();
		
		try {
			a.see_booking_details(uId);
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
		System.out.println(e);
		}
		
	}

	private static void viewflight() {
		
		Interface view_variable=new Implementation();
		List<Flight> flight_varable_list;
		try {
			flight_varable_list = view_variable.view_flight();
			System.out.println();
			flight_varable_list.forEach(a -> System.out.println(a));
			System.out.println();
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
		
	}

	private static void SearchFlight(Scanner sc) {
		
		System.out.println("Enter Departure city name");
		String departure_city_name=sc.next();
		System.out.println("Enter Destination city");
		String destination=sc.next();
		System.out.println("Enter no of seat reqired");
		int passenger_count=sc.nextInt();
		System.out.println("Enter date");
		LocalDate d=LocalDate.parse(sc.next());
		
		Interface serch_variable=new Implementation();
		
		List<Flight> list;
		try {
			list = serch_variable.serch(departure_city_name,destination,passenger_count,d);
			if(list!=null) {
				list.forEach(a-> System.out.println(a));
			}else {
				System.out.println("Flight not available");
			}
			
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
		  System.out.println(e);
		}
	
	}

	private static void filter_by_price_rangeanddeparturetime(Scanner sc) {
	
		
		
	}

	private static void selectdesireflight(Scanner sc, int uId) {
		
		viewflight(); 
		System.out.println("Enter flight id");
		String fligth_id=sc.next();
		
		Interface a=new Implementation();
		
		Flight flight;
		try {
			flight = a.Select(fligth_id);
			System.out.println();
			System.out.println(flight);
			System.out.println();
			Booking(sc,fligth_id,uId);
			
			
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}



	private static void Booking(Scanner sc,String fligth_id, int uId) {
		// TODO Auto-generated method stub
			
System.out.println("Enter name");
String name=sc.next();
System.out.println("Enter adhar number");
String adharno=sc.next();
System.out.println("Enter desire no of seat");
int noofseat=sc.nextInt();
if(noofseat <=12) {
	
}else {
	System.out.println("Enter desire no of seat ");
	 noofseat=sc.nextInt();
}
System.out.println("Enter Mobile number");
String mobileno=sc.next();

Interface a=new Implementation();
try {
	double p=a.book1(fligth_id,name,adharno,noofseat,mobileno,uId);
	System.out.println("");
	System.out.println("Your total ticket price is: "+ (noofseat*p));
	
	Payment(sc,noofseat*p,name );
} catch (SomeThingWentWrong e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

private static void Payment(Scanner sc, double d, String name) {
	double amount=0;
	do {
		
	System.out.println("Enter amount");
	 amount=sc.nextDouble();
	}while(amount!=d);
	System.out.println("Enter upi no.");
	String upino=sc.next();
	System.out.println("procced");
	System.out.println();
	int c;
	do {
		System.out.println("For confirmation of payment press 1");
		
		c=sc.nextInt();
		
		switch(c) {
		case 1:
			Call(name);
			break;
		default :
			System.out.println("Invalid selection");
			
		}
	

	}while(c!=1);
	
}

private static void Call(String name) {
	
	System.out.println("Your payment is successful,Happy journey "+name);
	
}
}
