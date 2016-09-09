package com.siwa.model;

public class Test {
	
	private int testID;
	private String testTime;
	
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	
	public String toString(){
		return "Test [testID=" + testID + ",testTime="+testTime+"]";
	}
}
