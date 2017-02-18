package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.siwa.model.AssignMilestone;
import com.siwa.util.DBUtil;

public class AssignMilestoneDAOImplementation implements AssignMilestoneDAO {
	private Connection conn;

	public AssignMilestoneDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addAssignMilestone(AssignMilestone assignMilestone) {
		try{
			String query = "set @milestone_id = (select milestone.milestoneID from milestone where milestone.milestoneName = ?)";
			String query3 = "insert into assignmilestone (milestoneID,issueID) values (@milestone_id,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps.setString(1, assignMilestone.getMilestoneName());
			ps3.setInt(1, assignMilestone.getIssueID());
			ps.executeQuery();
			ps3.executeUpdate();
			ps.close();
			ps3.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAssignMilestone(int assignMilestoneID) {
		try{
			String query = "delete from assignmilestone where assignMilestoneID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, assignMilestoneID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
