package com.siwa.dao;

import java.util.List;

import com.siwa.model.Comment;
import com.siwa.model.Issue;
import com.siwa.model.Person;

public interface CommentDAO {
	
		public void addComment(Comment comment);

		public void deleteComment(int commentID);

		public void updateComment(Comment comment);

		public List<Comment> getAllComment();

		public Comment getCommentById(int commentID);
		
		public Comment getCommentByIssue(int issueID);
		
		public Issue getIssueById(int issueID);
		
		public int getNoOfRecords();
		
		public List<Person> getPersonById(int issueID);
		
		public List<Comment> getFeedbackByUser(String user);
	
}
