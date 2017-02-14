package com.siwa.model;

public class AssignLabel {
	
	private int assignLabelID;
	private int labelID;
	private int issueID;
	private String labelName;
	
	public int getAssignLabelID() {
		return assignLabelID;
	}
	public void setAssignLabelID(int assignLabelID) {
		this.assignLabelID = assignLabelID;
	}
	public int getLabelID() {
		return labelID;
	}
	public void setLabelID(int labelID) {
		this.labelID = labelID;
	}
	public int getIssueID() {
		return issueID;
	}
	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	@Override
	public String toString() {
		return "AssignLabel [assignLabelID=" + assignLabelID + ", labelID=" + labelID + ", issueID=" + issueID
				+ ", labelName=" + labelName + "]";
	}

}
