package com.siwa.model;

public class AssignMilestone {
	
	private int assignMilestoneID;
	private int milestoneID;
	private int issueID;
	private String milestoneName;
	
	public int getAssignMilestoneID() {
		return assignMilestoneID;
	}
	public void setAssignMilestoneID(int assignMilestoneID) {
		this.assignMilestoneID = assignMilestoneID;
	}
	public int getMilestoneID() {
		return milestoneID;
	}
	public void setMilestoneID(int milestoneID) {
		this.milestoneID = milestoneID;
	}
	public int getIssueID() {
		return issueID;
	}
	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}
	public String getMilestoneName() {
		return milestoneName;
	}
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	@Override
	public String toString() {
		return "AssignMilestone [assignMilestoneID=" + assignMilestoneID + ", milestoneID=" + milestoneID + ", issueID="
				+ issueID + ", milestoneName=" + milestoneName + "]";
	}

}
