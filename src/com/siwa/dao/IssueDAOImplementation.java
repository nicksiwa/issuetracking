package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Comment;
import com.siwa.model.Index;
import com.siwa.model.Issue;
import com.siwa.util.DBUtil;

public class IssueDAOImplementation implements IssueDAO {
	
	private Connection conn;

	public IssueDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addIssue(Issue issue) {
		try{
			String query = "insert into issue (project,assign,title,description,severity,priority,dueDate,updateDate,status,reporter) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getProject());
			ps.setString(2, issue.getAssign());
			ps.setString(3, issue.getTitle());
			ps.setString(4, issue.getDescription());
			ps.setString(5, issue.getSeverity());
			ps.setString(6, issue.getPriority());
			ps.setDate(7,new java.sql.Date (issue.getDueDate().getTime()));
			ps.setString(8, issue.getUpdateDate());
			ps.setString(9, issue.getStatus());
			ps.setString(10, issue.getReporter());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteIssue(int issueID) {
		try{
			String query = "delete from issue where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateIssue(Issue issue) {
		try{
			String query = "update issue set project=?, assign=?, title=?, description=?, severity=?, priority=?, dueDate=?, updateDate=?, status=?, reporter=? where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getProject());
			ps.setString(2, issue.getAssign());
			ps.setString(3, issue.getTitle());
			ps.setString(4, issue.getDescription());
			ps.setString(5, issue.getSeverity());
			ps.setString(6, issue.getPriority());
			ps.setDate(7,new java.sql.Date (issue.getDueDate().getTime()));
			ps.setString(8, issue.getUpdateDate());
			ps.setString(9, issue.getStatus());
			ps.setString(10, issue.getReporter());
			ps.setInt(11, issue.getIssueID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Issue> getAllIssue() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from issue");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setIssueID(rs.getInt("issueID"));
				issue.setProject(rs.getString("project"));
				issue.setAssign(rs.getString("assign"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getString("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issues.add(issue);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issues;
	}

	@Override
	public Issue getAssignById(int issueID) {
		Issue issue = new Issue();
		try{
			String query = "select * from issue where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				issue.setIssueID(rs.getInt("issueID"));
				issue.setProject(rs.getString("project"));
				issue.setAssign(rs.getString("assign"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getString("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issue;
	}

	@Override
	public List<Issue> getPersonAndProject() {
		List<Issue> issuess = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select projectName,firstName from project,person");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setProject(rs.getString("projectName"));
				issue.setAssign(rs.getString("firstName"));
				issuess.add(issue);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issuess;
	}

	@Override
	public List<Comment> getCommentByIssue(int issueID) {
		List<Comment> comments = new ArrayList<Comment>();
		try{
			String query = "select * from comment where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setDescription(rs.getString("description"));
				comment.setStatus(rs.getString("status"));
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comments.add(comment);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comments;
	}

}
