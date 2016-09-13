package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.siwa.model.Issue;
import com.siwa.util.DBUtil;

public class IssueDAOImplementation implements IssueDAO{
	
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
			ps.setDate(5, new java.sql.Date (issue.getUpdateDate().getTime()));
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteIssue(int issueID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIssue(Issue issue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Issue> getAllIssue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue getIssueById(int issueID) {
		// TODO Auto-generated method stub
		return null;
	}

}
