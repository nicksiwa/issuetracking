package com.siwa.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Comment {
	private int commentID;
	private String commentDetail;
	private Timestamp commentTime;
	private String userComment;
	private String commentStatus;
	private int issueID;
	private String commentAssign;
	private String commentIcon;
	private String commentIconColor;
	
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
	
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	
	public String getCommentDetail() {
		return commentDetail;
	}
	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	
	public int getIssueID() {
		return issueID;
	}
	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentAssign() {
		return commentAssign;
	}
	public void setCommentAssign(String commentAssign) {
		this.commentAssign = commentAssign;
	}
	
	public String getCommentIcon() {
		return commentIcon;
	}
	public void setCommentIcon(String commentIcon) {
		this.commentIcon = commentIcon;
	}
	
	public String getCommentIconColor() {
		return commentIconColor;
	}
	public void setCommentIconColor(String commentIconColor) {
		this.commentIconColor = commentIconColor;
	}
	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", commentDetail=" + commentDetail + ", commentTime=" + commentTime
				+ ", userComment=" + userComment + ", commentStatus=" + commentStatus + ", issueID=" + issueID
				+ ", commentAssign=" + commentAssign + ", commentIcon=" + commentIcon + ", commentIconColor="
				+ commentIconColor + "]";
	}
	
}
