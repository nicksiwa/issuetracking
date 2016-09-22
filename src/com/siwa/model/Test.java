package com.siwa.model;



public class Test {
	
	private int testID;
	private String testName;
	private String testProject;
	
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestProject() {
		return testProject;
	}
	public void setTestProject(String testProject) {
		this.testProject = testProject;
	}
	@Override
	public String toString() {
		return "Test [testID=" + testID + ", testName=" + testName + ", testProject=" + testProject + "]";
	}

	

	
}
