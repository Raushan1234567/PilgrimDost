package com.masai.Pilgrimdost.Dto;

import jakarta.persistence.*;

@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int booking_id;
private String traveller_name;
private int desireno_of_seat;
private String mobileno;
private String Adharno;
@ManyToOne
private Flight flight;
@ManyToOne
private User users;
public Booking() {
	super();
	// TODO Auto-generated constructor stub
}
public Booking(String traveller_name, int desireno_of_seat, String mobileno, String adharno, Flight flight,
		User users) {
	super();
	this.traveller_name = traveller_name;
	this.desireno_of_seat = desireno_of_seat;
	this.mobileno = mobileno;
	Adharno = adharno;
	this.flight = flight;
	this.users = users;
}
public int getBooking_id() {
	return booking_id;
}
public void setBooking_id(int booking_id) {
	this.booking_id = booking_id;
}
public String getTraveller_name() {
	return traveller_name;
}
public void setTraveller_name(String traveller_name) {
	this.traveller_name = traveller_name;
}
public int getDesireno_of_seat() {
	return desireno_of_seat;
}
public void setDesireno_of_seat(int desireno_of_seat) {
	this.desireno_of_seat = desireno_of_seat;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getAdharno() {
	return Adharno;
}
public void setAdharno(String adharno) {
	Adharno = adharno;
}
public Flight getFlight() {
	return flight;
}
public void setFlight(Flight flight) {
	this.flight = flight;
}
public User getUsers() {
	return users;
}
public void setUsers(User users) {
	this.users = users;
}
@Override
public String toString() {
	return "Booking [booking_id=" + booking_id + ", traveller_name=" + traveller_name + ", desireno_of_seat="
			+ desireno_of_seat + ", mobileno=" + mobileno + ", Adharno=" + Adharno + ", flight=" + flight + ", users="
			+ users + "]";
}





}
