package com.siwa.model;

public class File {
	
	private int fileID;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileID() {
		return fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	@Override
	public String toString() {
		return "File [fileID=" + fileID + ", fileName=" + fileName + "]";
	}
	
}
