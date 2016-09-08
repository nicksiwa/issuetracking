package com.siwa.model;

import java.sql.Timestamp;

public class Comment {

	private int commentID;
	private String description;
	private String status;
	private Timestamp date;

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String toString() {
		return "Comment [commentID=" + commentID + ",description=" + description + ",status=" + status + ",date="
				+ date + "]";
	}

}
