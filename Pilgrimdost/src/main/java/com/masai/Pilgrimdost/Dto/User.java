package com.masai.Pilgrimdost.Dto;

import jakarta.persistence.Entity;

@Entity
public class User extends Supperuser{
	
	private String email;
	private String password;
	private String Address;
	private String pincode;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String role, String email, String password, String address, String pincode) {
		super(name, role);
		this.email = email;
		this.password = password;
		Address = address;
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", Address=" + Address + ", pincode=" + pincode
				+ "]";
	}
	
	
	

}
