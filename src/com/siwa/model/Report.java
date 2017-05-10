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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
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
	@Override
	public String toString() {
		return "Report [project=" + project + ", assign=" + assign + ", title=" + title + ", projectName=" + projectName
				+ ", description=" + description + ", severity=" + severity + ", createDate=" + createDate
				+ ", startDate=" + startDate + ", finishDate=" + finishDate + ", status=" + status + "]";
	}

}
