package com.siwa.model;

import java.util.Date;

public class Person {

	private int personId;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String tel;
	private String position;
	private Date birthDate;
	private int assignID;
	private int projectID;
	private String github;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAssignID() {
		return assignID;
	}

	public void setAssignID(int assignID) {
		this.assignID = assignID;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", address=" + address + ", tel=" + tel + ", position=" + position + ", birthDate="
				+ birthDate + ", assignID=" + assignID + ", projectID=" + projectID + ", github=" + github + "]";
	}
	
}
