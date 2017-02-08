package com.siwa.model;

public class Milestone {
	
	private int milestoneID;
	private String milestoneName;
	private String milestoneDescription;
	private int milestoneProject;
	
	public int getMilestoneID() {
		return milestoneID;
	}
	public void setMilestoneID(int milestoneID) {
		this.milestoneID = milestoneID;
	}
	public String getMilestoneName() {
		return milestoneName;
	}
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	public String getMilestoneDescription() {
		return milestoneDescription;
	}
	public void setMilestoneDescription(String milestoneDescription) {
		this.milestoneDescription = milestoneDescription;
	}
	public int getMilestoneProject() {
		return milestoneProject;
	}
	public void setMilestoneProject(int milestoneProject) {
		this.milestoneProject = milestoneProject;
	}
	@Override
	public String toString() {
		return "Milestone [milestoneID=" + milestoneID + ", milestoneName=" + milestoneName + ", milestoneDescription="
				+ milestoneDescription + ", milestoneProject=" + milestoneProject + "]";
	}

	
}
