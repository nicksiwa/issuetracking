package com.siwa.model;

public class Comment {
	private int commentID;
	private String description;
	private String status;
	private String commentTime;
	private String userComment;
	
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
	
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", description=" + description + ", status=" + status
				+ ", commentTime=" + commentTime + ", userComment=" + userComment + "]";
	}
	
	
	
}
