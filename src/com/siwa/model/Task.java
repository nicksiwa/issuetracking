package com.siwa.model;

import java.sql.Timestamp;

public class Task {
	
	private int taskID;
	private String taskDetail;
	private int taskType;
	private Timestamp createDate;
	private String createBy;
	private int taskProject;
	
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public String getTaskDetail() {
		return taskDetail;
	}
	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public int getTaskProject() {
		return taskProject;
	}
	public void setTaskProject(int taskProject) {
		this.taskProject = taskProject;
	}
	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", taskDetail=" + taskDetail + ", taskType=" + taskType + ", createDate="
				+ createDate + ", createBy=" + createBy + ", taskProject=" + taskProject + "]";
	}
	
	
}
