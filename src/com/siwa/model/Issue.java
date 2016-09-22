package com.siwa.model;

import java.sql.Blob;
import java.util.Date;

public class Issue {

	private int issueID;
	private String project;
	private String assign;
	private String title;
	private String description;
	private String severity;
	private String priority;
	private Date dueDate;
	private String updateDate;
	//private Blob attachFile;
	private String status;

	public int getIssueID() {
		return issueID;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/*public Blob getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(Blob attachFile) {
		this.attachFile = attachFile;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Issue [issueID=" + issueID + ", project=" + project + ", assign=" + assign + ", title=" + title
				+ ", description=" + description + ", severity=" + severity + ", priority=" + priority + ", dueDate="
				+ dueDate + ", updateDate=" + updateDate + ", status=" + status + "]";
	}

	
	
}
