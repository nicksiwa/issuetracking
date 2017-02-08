package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Milestone;
import com.siwa.util.DBUtil;

public class MilestoneDAOImplementation implements MilestoneDAO {

	private Connection conn;

	public MilestoneDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addMilestone(Milestone milestone) {
		try{
			String query = "insert into milestone (milestoneName, milestoneDescription, milestoneProject) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, milestone.getMilestoneName());
			ps.setString(2, milestone.getMilestoneDescription());
			ps.setInt(3, milestone.getMilestoneProject());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMilestone(int milestoneID) {
		try{
			String query = "delete from milestone where milestoneID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, milestoneID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Milestone> getAllMilestone() {
		List<Milestone> milestones = new ArrayList<Milestone>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from milestone");
			while(rs.next()){
				Milestone milestone = new Milestone();
				milestone.setMilestoneID(rs.getInt("milestoneID"));
				milestone.setMilestoneName(rs.getString("milestoneName"));
				milestone.setMilestoneDescription(rs.getString("milestoneDescription"));
				milestone.setMilestoneProject(rs.getInt("milestoneProject"));
				milestones.add(milestone);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return milestones;
	}

}
