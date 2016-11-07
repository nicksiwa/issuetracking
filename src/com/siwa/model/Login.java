package com.siwa.model;

public class Login {
	
	private String username;
	private String password;
	private String firstname;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", firstname=" + firstname + "]";
	}

}
