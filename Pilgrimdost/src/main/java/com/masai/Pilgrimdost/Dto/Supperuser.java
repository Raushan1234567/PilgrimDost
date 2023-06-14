package com.masai.Pilgrimdost.Dto;

import jakarta.persistence.*;

@MappedSuperclass
public class Supperuser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String name;
	private String role;
	public Supperuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supperuser(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	
	public int getUserid() {
		return userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Supperuser [userid=" + userid + ", name=" + name + ", role=" + role + "]";
	}
	
	

}
