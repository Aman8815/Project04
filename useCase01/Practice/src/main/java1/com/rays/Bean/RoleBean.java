package com.rays.Bean;

public class RoleBean {
	
	private int id;
	private String name;
	
	public static int ADMIN = 1;
	public static int DOCTOR = 2;
	public static int NURSE = 3;
	public static int ACCOUNT = 4;
	
	
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

}
