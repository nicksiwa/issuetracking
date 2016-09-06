package com.siwa.model;

import java.util.Date;

public class Project {
	
	private int projectID;
	private String projectName;
	private String status;
	private String description;
	private Date startDate;
	private Date dueDate;
	
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String toString(){
		return "Project [projectID=" + projectID + ",projectName="+projectName+",status="
				+status+",description="+description+",startDate="+startDate+",dueDate="+dueDate+"]";
	}
}
