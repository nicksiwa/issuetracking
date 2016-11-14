package com.siwa.model;

public class Index {
	
	private int issueID;
	private String project;
	private String assign;
	private String title;
	private String updateDate;
	private String reporter;
	private String status;
	private int projectID;
	private String projectStatus;
	
	
	public int getIssueID() {
		return issueID;
	}
	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}
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
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	@Override
	public String toString() {
		return "Index [issueID=" + issueID + ", project=" + project + ", assign=" + assign + ", title=" + title
				+ ", updateDate=" + updateDate + ", reporter=" + reporter + ", status=" + status + ", projectID="
				+ projectID + ", projectStatus=" + projectStatus + "]";
	}
	
}
