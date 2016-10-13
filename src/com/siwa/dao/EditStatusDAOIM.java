package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.siwa.model.Issue;
import com.siwa.util.DBUtil;

public class EditStatusDAOIM implements EditStatusDAO {
	
	private Connection conn;
	
	public EditStatusDAOIM() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void editIssueStatus(Issue issue) {
		try{
			String query = "update issue set status=?, updateDate=? where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getStatus());
			ps.setString(2, issue.getUpdateDate());
			ps.setInt(3, issue.getIssueID());
			
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Issue getIsuseStatusById(int issueID) {
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
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
