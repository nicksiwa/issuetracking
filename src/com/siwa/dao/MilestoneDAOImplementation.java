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

	@Override
	public List<Milestone> getAllMilestoneByProjectId(int projectID) {
		List<Milestone> milestones = new ArrayList<Milestone>();
		try{
			String query = "select * from milestone where milestoneProject=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Milestone milestone = new Milestone();
				milestone.setMilestoneID(rs.getInt("milestoneID"));
				milestone.setMilestoneName(rs.getString("milestoneName"));
				milestone.setMilestoneDescription(rs.getString("milestoneDescription"));
				milestone.setMilestoneProject(rs.getInt("milestoneProject"));
				milestones.add(milestone);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return milestones;
	}

	@Override
	public List<Milestone> getMilestoneByIssueId(int issueID) {
		List<Milestone> milestones = new ArrayList<Milestone>();
		try{
			String query = "set @project_id =(select project.projectID from project join issue on issue.project = project.projectName and issue.issueID = ?)";
			String query2 = "select * from milestone where milestoneProject=@project_id";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps.setInt(1, issueID);
			ps.executeQuery();
			ResultSet rs = ps2.executeQuery();
			while(rs.next()){
				Milestone milestone = new Milestone();
				milestone.setMilestoneID(rs.getInt("milestoneID"));
				milestone.setMilestoneName(rs.getString("milestoneName"));
				milestone.setMilestoneDescription(rs.getString("milestoneDescription"));
				milestone.setMilestoneProject(rs.getInt("milestoneProject"));
				milestones.add(milestone);
			}
			rs.close();
			ps2.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return milestones;
	}

	@Override
	public List<Milestone> getAssignMilestone(int issueID) {
		List<Milestone> milestonesAssigns = new ArrayList<Milestone>();
		try{
			String query = "select milestone.milestoneID,milestone.milestoneName,milestone.milestoneDescription,milestone.milestoneProject from milestone join assignmilestone on milestone.milestoneID = assignmilestone.milestoneID join issue on assignmilestone.issueID = issue.issueID and issue.issueID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Milestone milestone = new Milestone();
				milestone.setMilestoneID(rs.getInt("milestoneID"));
				milestone.setMilestoneName(rs.getString("milestoneName"));
				milestone.setMilestoneDescription(rs.getString("milestoneDescription"));
				milestone.setMilestoneProject(rs.getInt("milestoneProject"));
				milestonesAssigns.add(milestone);
			}
			ps.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return milestonesAssigns;
	}

}
