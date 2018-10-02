package com.service.model;

public class Admin {
	private String id;
	private String user;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public Admin(String id, String user, String password) {
		this.id = id;
		this.user = user;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
