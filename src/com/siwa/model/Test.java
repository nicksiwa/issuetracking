package com.siwa.model;

import java.sql.Blob;

public class Test {
	
	private int testID;
	private Blob file;
	
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
	public String toString(){
		return "Test [testID="+testID+",file="+file+"]";
	}

}
