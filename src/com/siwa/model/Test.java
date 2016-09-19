package com.siwa.model;

import java.sql.Blob;

public class Test {
	
	private int testID;
	private Blob file;
	private int testProject;
	private int testComment; 
	
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public int getTestProject() {
		return testProject;
	}
	public void setTestProject(int testProject) {
		this.testProject = testProject;
	}
	
	public int getTestComment() {
		return testComment;
	}
	public void setTestComment(int testComment) {
		this.testComment = testComment;
	}
	
	
	public String toString(){
		return "Test [testID="+testID+",file="+file+",testProject="+testProject+",testComment="+testComment+"]";
	}
	
	
	
	
	

}
