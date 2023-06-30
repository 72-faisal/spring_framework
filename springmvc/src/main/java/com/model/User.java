package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name, address;
	
	
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public User(int id, String name, String address) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.address = address;
//	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
