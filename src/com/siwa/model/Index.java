package com.siwa.model;

public class Index {
	
	private int indexID;
	private String assignName;
	private String assignProject;
	private String reportName;
	private String reportProject;
	
	public int getIndexID() {
		return indexID;
	}
	public void setIndexID(int indexID) {
		this.indexID = indexID;
	}
	public String getAssignName() {
		return assignName;
	}
	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}
	public String getAssignProject() {
		return assignProject;
	}
	public void setAssignProject(String assignProject) {
		this.assignProject = assignProject;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportProject() {
		return reportProject;
	}
	public void setReportProject(String reportProject) {
		this.reportProject = reportProject;
	}
	@Override
	public String toString() {
		return "Index [indexID=" + indexID + ", assignName=" + assignName + ", assignProject=" + assignProject
				+ ", reportName=" + reportName + ", reportProject=" + reportProject + "]";
	}
	

}
