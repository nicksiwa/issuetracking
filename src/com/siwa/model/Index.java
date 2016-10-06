package com.siwa.model;

public class Index {
	
	private int issueID;
	private String project;
	private String assign;
	private String title;
	private String updateDate;
	
	
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
	@Override
	public String toString() {
		return "Index [issueID=" + issueID + ", project=" + project + ", assign=" + assign + ", title=" + title
				+ ", updateDate=" + updateDate + "]";
	}
	
}
