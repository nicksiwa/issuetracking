package com.siwa.model;

import java.sql.Blob;
import java.sql.Timestamp;
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
	private Timestamp updateDate;
	//private Blob attachFile;
	private String status;
	private String reporter;
	private Timestamp createDate;
	private int milestoneID;
	private long dueDateChecker;
	private String email_id;
	private String email_password;


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

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public int getMilestoneID() {
		return milestoneID;
	}

	public void setMilestoneID(int milestoneID) {
		this.milestoneID = milestoneID;
	}

	public long getDueDateChecker() {
		return dueDateChecker;
	}

	public void setDueDateChecker(long dueDateChecker) {
		this.dueDateChecker = dueDateChecker;
	}

	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_password() {
		return email_password;
	}

	public void setEmail_password(String email_password) {
		this.email_password = email_password;
	}

	@Override
	public String toString() {
		return "Issue [issueID=" + issueID + ", project=" + project + ", assign=" + assign + ", title=" + title
				+ ", description=" + description + ", severity=" + severity + ", priority=" + priority + ", dueDate="
				+ dueDate + ", updateDate=" + updateDate + ", status=" + status + ", reporter=" + reporter
				+ ", createDate=" + createDate + ", milestoneID=" + milestoneID + ", dueDateChecker=" + dueDateChecker
				+ ", email_id=" + email_id + ", email_password=" + email_password + "]";
	}
	
}
