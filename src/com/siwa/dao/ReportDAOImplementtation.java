package com.siwa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Issue;
import com.siwa.util.DBUtil;

public class ReportDAOImplementtation {
	
	private Connection conn;
	
	public ReportDAOImplementtation() {
		conn = DBUtil.getConnection();
	}
	public List<Issue> getAllIssue() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from issue");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setIssueID(rs.getInt("project"));
				issue.setProject(rs.getString("assign"));
				issue.setAssign(rs.getString("title"));
				issue.setTitle(rs.getString("projectName"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("createDate"));
				issue.setDueDate(rs.getDate("startDate"));
				issue.setUpdateDate(rs.getTimestamp("finishDate"));
				issue.setStatus(rs.getString("status"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issues;
	}
}
