package com.siwa.model;

public class Assign {
	
	private int assignID;
	private int personID;
	private int projectID;
	
	public int getAssignID() {
		return assignID;
	}
	public void setAssignID(int assignID) {
		this.assignID = assignID;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	@Override
	public String toString() {
		return "Assign [assignID=" + assignID + ", personID=" + personID + ", projectID=" + projectID + "]";
	}
	

}
