package com.siwa.dao;

import java.util.List;

import com.siwa.model.Issue;
import com.siwa.model.Project;
import com.siwa.model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Issue;
import com.siwa.model.Project;
import com.siwa.model.Report;
import com.siwa.util.DBUtil;

public class ReportDAOImplementation implements ReportDAO{
	private int noOfRecords;
	Statement stmt;
	private Connection conn;
	
	public ReportDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public List<Issue> getAllIssue() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT SUBSTR(createDate,6,2) AS mount,COUNT(*) AS number FROM  issue GROUP BY  MONTH(issue.createDate) ");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setAssign(rs.getString("number"));
				issue.setProject(rs.getString("mount"));
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
	public List<Project> getAllproject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllproject2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> IssueID(int offset, int noOfRecords) {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			String query = "select SQL_CALC_FOUND_ROWS * from issue ORDER BY issueID DESC limit ?,? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, offset);
			ps.setInt(2, noOfRecords);
			stmt = conn.createStatement();
			ResultSet rs = ps.executeQuery();
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
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
                this.noOfRecords = rs.getInt(1);
		}catch(SQLException e){
			 e.printStackTrace();
		}
		return issues;
	}
	
	public int getNoOfRecords() {
		return noOfRecords;
	}

	@Override
	public List<Issue> SeveritySort(int offset, int noOfRecords) {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			String query = "select SQL_CALC_FOUND_ROWS * from issue ORDER BY severity ASC limit ?,? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, offset);
			ps.setInt(2, noOfRecords);
			stmt = conn.createStatement();
			ResultSet rs = ps.executeQuery();

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
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
                this.noOfRecords = rs.getInt(1);
		}catch(SQLException e){
			 e.printStackTrace();
		}
		return issues;
	}

	@Override
	public List<Issue> DueDateSort(int offset, int noOfRecords) {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			String query = "select SQL_CALC_FOUND_ROWS * from issue ORDER BY dueDate ASC limit ?,? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, offset);
			ps.setInt(2, noOfRecords);
			stmt = conn.createStatement();
			ResultSet rs = ps.executeQuery();

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
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
                this.noOfRecords = rs.getInt(1);
		}catch(SQLException e){
			 e.printStackTrace();
		}
		return issues;
	}

	@Override
	public List<Issue> UpdateDateSort(int offset, int noOfRecords) {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			String query = "select SQL_CALC_FOUND_ROWS * from issue ORDER BY updateDate ASC limit ?,? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, offset);
			ps.setInt(2, noOfRecords);
			stmt = conn.createStatement();
			ResultSet rs = ps.executeQuery();

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
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
                this.noOfRecords = rs.getInt(1);
		}catch(SQLException e){
			 e.printStackTrace();
		}
		return issues;
	}

	@Override
	public List<Issue> CreateDateSort(int offset, int noOfRecords) {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			String query = "select SQL_CALC_FOUND_ROWS * from issue ORDER BY createDate ASC limit ?,? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, offset);
			ps.setInt(2, noOfRecords);
			stmt = conn.createStatement();
			ResultSet rs = ps.executeQuery();
			

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
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
                this.noOfRecords = rs.getInt(1);
		}catch(SQLException e){
			 e.printStackTrace();
		}
		return issues;
	}

	@Override
	public List<Issue> getNumberofIssue() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT COUNT(*) FROM  issue GROUP BY  MONTH(issue.createDate)");
			while(rs.next()){
				Issue issue = new Issue();
				
				issue.setAssign(rs.getString("COUNT(*)"));
				
				issues.add(issue);
				System.out.print(issues);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issues;
	}

	@Override
	public List<Issue> Pagination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> GrapStatus() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT issue.`status` ,COUNT(*) FROM  issue GROUP BY  issue.`status` ");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setStatus(rs.getString("status"));
				issue.setAssign(rs.getString("COUNT(*)"));
				
				issues.add(issue);
				System.out.print(issues);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issues;
	}

}
