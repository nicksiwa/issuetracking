package com.siwa.model;

public class Label {
	
	private int labelID;
	private String labelName;
	private String labelType;
	private int labelProject;
	
	public int getLabelID() {
		return labelID;
	}
	public void setLabelID(int labelID) {
		this.labelID = labelID;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getLabelType() {
		return labelType;
	}
	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}
	public int getLabelProject() {
		return labelProject;
	}
	public void setLabelProject(int labelProject) {
		this.labelProject = labelProject;
	}
	@Override
	public String toString() {
		return "Label [labelID=" + labelID + ", labelName=" + labelName + ", labelType=" + labelType + ", labelProject="
				+ labelProject + "]";
	}

}
