package com.siwa.model;

import java.util.Date;

public class Report {
private String project;
private String assign;
private String title;
private String projectName;
private String description;
private String severity;
private Date createDate;
private Date startDate;
private Date finishDate;
private String status;

public String getProject() {
	return project;
}
public void setProject(String project) {
	this.project = project;
}
public String getAssign() {
	return assign;
}
public void setAssign(String assign) {
	this.assign = assign;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getSeverity() {
	return severity;
}
public void setSeverity(String severity) {
	this.severity = severity;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
private Date getStartDate() {
	return startDate;
}
private void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getFinishDate() {
	return finishDate;
}
public void setFinishDate(Date finishDate) {
	this.finishDate = finishDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
}
