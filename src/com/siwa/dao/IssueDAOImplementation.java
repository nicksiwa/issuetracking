package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			String query = "insert into issue (title,description,severity,priority,dueDate,updateDate,attachFile,status) values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getTitle());
			ps.setString(2, issue.getDescription());
			ps.setString(3, issue.getSeverity());
			ps.setString(4, issue.getPriority());
			ps.setDate(5, new java.sql.Date (issue.getDueDate().getTime()));
			ps.setString(6, issue.getUpdateDate());
			ps.setBlob(7, issue.getAttachFile());
			ps.setString(8, issue.getStatus());
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
			String query = "update issue set title=?, description=?, severity=?, priority=?, dueDate=?, updateDate=?, attachFile=?, status=? where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getTitle());
			ps.setString(2, issue.getDescription());
			ps.setString(3, issue.getSeverity());
			ps.setString(4, issue.getPriority());
			ps.setDate(5, new java.sql.Date (issue.getDueDate().getTime()));
			ps.setString(6, issue.getUpdateDate());
			ps.setBlob(7, issue.getAttachFile());
			ps.setString(8, issue.getStatus());
			ps.setInt(9, issue.getIssueID());
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Issue> getAllIssues() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from issue");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setIssueID(rs.getInt("issueID"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getString("updateDate"));
				issue.setAttachFile(rs.getBlob("attachFile"));
				issue.setStatus(rs.getString("status"));
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
	public Issue getIssueById(int issueID) {
		Issue issue = new Issue();
		try{
			String query = "select * from issue where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				issue.setIssueID(rs.getInt("issueID"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getString("updateDate"));
				issue.setAttachFile(rs.getBlob("attachFile"));
				issue.setStatus(rs.getString("status"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issue;
	}

}
