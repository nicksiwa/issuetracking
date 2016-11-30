package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Assign;
import com.siwa.model.Comment;
import com.siwa.model.Issue;
import com.siwa.model.Person;
import com.siwa.util.DBUtil;

public class CommentDAOImplementation implements CommentDAO {
	
	private Connection conn;
	private int noOfRecords;
	Statement statement;

	public CommentDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addComment(Comment comment) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "insert into comment (commentDetail,commentTime,userComment,commentStatus,issueID,commentAssign) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, comment.getCommentDetail());
			ps.setTimestamp(2, new Timestamp(date.getTime()));	
			ps.setString(3, comment.getUserComment());
			ps.setString(4, comment.getCommentStatus());
			ps.setInt(5, comment.getIssueID());
			ps.setString(6, comment.getCommentAssign());
			ps.executeUpdate();
			ps.close();
					
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteComment(int commentID) {
		try{
			String query = "delete from comment where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, commentID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateComment(Comment comment) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "update comment set commentDetail=?, commentTime=?, userComment=?, commentStatus=?, issueID=?, commentAssign=? where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, comment.getCommentDetail());
			ps.setTimestamp(2, new Timestamp(date.getTime()));
			ps.setString(3, comment.getUserComment());
			ps.setString(4, comment.getCommentStatus());
			ps.setInt(5, comment.getIssueID());
			ps.setString(6, comment.getCommentAssign());
			ps.setInt(7, comment.getCommentID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Comment> getAllComment() {
		List<Comment> comments = new ArrayList<Comment>();
		try{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from comment");
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setCommentDetail(rs.getString("commentDetail"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comment.setCommentStatus(rs.getString("commentStatus"));
				comment.setIssueID(rs.getInt("issueID"));
				comment.setCommentAssign(rs.getString("commentAssign"));
				comments.add(comment);
			}
			rs.close();
			statement.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comments;
	}

	
	public int getNoOfRecords(){
		return noOfRecords;
	}
	
	
	@Override
	public Comment getCommentById(int commentID) {
		Comment comment = new Comment();
		try{
			String query = "select * from comment where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, commentID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				comment.setCommentID(rs.getInt("commentID"));
				comment.setCommentDetail(rs.getString("commentDetail"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comment.setCommentStatus(rs.getString("commentStatus"));
				comment.setIssueID(rs.getInt("issueID"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public Comment getCommentByIssue(int issueID) {
		Comment comment = new Comment();
		try{
			String query = "select * from comment where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				comment.setCommentID(rs.getInt("commentID"));
				comment.setCommentDetail(rs.getString("commentDetail"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comment.setCommentStatus(rs.getString("commentStatus"));
				comment.setIssueID(rs.getInt("issueID"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public Issue getIssueById(int issueID) {
		Issue issue = new Issue();
		try{
			String query = "select issueID,status from issue where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				issue.setIssueID(rs.getInt("issueID"));
				issue.setStatus(rs.getString("status"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issue;
	}

	
	
	@Override
	public List<Person> getPersonById(int issueID) {
		List<Person> persons = new ArrayList<Person>();
		try{
			String query = "select CONCAT_WS (' ',firstName, lastName) as full_name from person join assign on person.personId = assign.person_ID join project on assign.project_ID = project.projectID join issue on project.projectName = issue.project and issue.issueID=?";			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				person.setFirstName(rs.getString("full_name"));
				persons.add(person);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return persons;
	}

	@Override
	public List<Comment> getFeedbackByUser(String user) {
		List<Comment> feedback = new ArrayList<Comment>();
		try{
			String query = "select `comment`.commentDetail,`comment`.commentTime,`comment`.userComment,`comment`.issueID from `comment` where `comment`.commentAssign=? order by commentTime desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentDetail(rs.getString("commentDetail"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comment.setIssueID(rs.getInt("issueID"));
				feedback.add(comment);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return feedback;
	}

}
