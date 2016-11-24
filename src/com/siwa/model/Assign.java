package com.siwa.model;

public class Assign {
	
	private int assignID;
	private int personID;
	private int projectID;
	private String personName;
	private String projectName;
	
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
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Override
	public String toString() {
		return "Assign [assignID=" + assignID + ", personID=" + personID + ", projectID=" + projectID + ", personName="
				+ personName + ", projectName=" + projectName + "]";
	}
	

}
