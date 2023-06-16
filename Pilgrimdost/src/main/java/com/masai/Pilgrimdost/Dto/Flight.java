package com.masai.Pilgrimdost.Dto;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Flight {
 @Id
 private String  flightid;
 private String FlightName;
 private String  StartingPoint;
 private String EndingPoint;
 private double price;
 private LocalDate Startdate;
 private LocalDate EndDate;
 private int totalseat;
 private int availableseat;
 private String jouneyhour;
public Flight() {
	super();
	// TODO Auto-generated constructor stub
}
public Flight(String flightid, String flightName, String startingPoint, String endingPoint, double price,
		LocalDate startdate, LocalDate endDate, int totalseat, int availableseat, String jouneyhour) {
	super();
	this.flightid = flightid;
	FlightName = flightName;
	StartingPoint = startingPoint;
	EndingPoint = endingPoint;
	this.price = price;
	Startdate = startdate;
	EndDate = endDate;
	this.totalseat = totalseat;
	this.availableseat = availableseat;
	this.jouneyhour = jouneyhour;
}
public String getFlightid() {
	return flightid;
}
public void setFlightid(String flightid) {
	this.flightid = flightid;
}
public String getFlightName() {
	return FlightName;
}
public void setFlightName(String flightName) {
	FlightName = flightName;
}
public String getStartingPoint() {
	return StartingPoint;
}
public void setStartingPoint(String startingPoint) {
	StartingPoint = startingPoint;
}
public String getEndingPoint() {
	return EndingPoint;
}
public void setEndingPoint(String endingPoint) {
	EndingPoint = endingPoint;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDate getStartdate() {
	return Startdate;
}
public void setStartdate(LocalDate startdate) {
	Startdate = startdate;
}
public LocalDate getEndDate() {
	return EndDate;
}
public void setEndDate(LocalDate endDate) {
	EndDate = endDate;
}
public int getTotalseat() {
	return totalseat;
}
public void setTotalseat(int totalseat) {
	this.totalseat = totalseat;
}
public int getAvailableseat() {
	return availableseat;
}
public void setAvailableseat(int availableseat) {
	this.availableseat = availableseat;
}
public String getJouneyhour() {
	return jouneyhour;
}
public void setJouneyhour(String jouneyhour) {
	this.jouneyhour = jouneyhour;
}
@Override
public String toString() {
	return "Flight [flightid=" + flightid + ", FlightName=" + FlightName + ", StartingPoint=" + StartingPoint
			+ ", EndingPoint=" + EndingPoint + ", price=" + price + ", Startdate=" + Startdate + ", EndDate=" + EndDate
			+ ", totalseat=" + totalseat + ", availableseat=" + availableseat + ", jouneyhour=" + jouneyhour + "]";
}
 
 
 
}
