package com.siwa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Issue;
import com.siwa.util.DBUtil;

public class PaginationDAO {
	
	Connection conn;
    Statement stmt;
    private int noOfRecords;
    
    public PaginationDAO(){
    	conn = DBUtil.getConnection();
    }
    
   
	public List<Issue> getAllIssueByPagination(int offset, int noOfRecords) {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			String query = "select SQL_CALC_FOUND_ROWS * from issue limit ?,?";
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

}
