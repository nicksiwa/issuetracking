package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Project;
import com.siwa.util.DBUtil;

public class ProjectDAOImplementation implements ProjectDAO {
	
	private Connection conn;

	public ProjectDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addProject(Project project) {
		try{
			String query = "insert into project (projectName, status, description, startDate, finishDate, viewStatus) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getStatus());
			ps.setString(3, project.getDescription());
			ps.setDate(4,new java.sql.Date( project.getStartDate().getTime()));
			ps.setDate(5,new java.sql.Date( project.getFinishDate().getTime()));
			ps.setString(6, project.getViewStatus());
		
			ps.executeUpdate();
			ps.close();	
		}catch(SQLException e){
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteProject(int projectID) {
		try{
			String query = "delete from project where projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProject(Project project) {
		try{
			String query = "update project set projectName=?, status=?, description=?, startDate=?, finishDate=?, viewStatus=? where projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getStatus());
			ps.setString(3, project.getDescription());
			ps.setDate(4,new java.sql.Date( project.getStartDate().getTime()));
			ps.setDate(5,new java.sql.Date( project.getFinishDate().getTime()));
			ps.setString(6, project.getViewStatus());
			ps.setInt(7, project.getProjectID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		try{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from project");
			while(rs.next()){
				Project project = new Project();
				project.setProjectID(rs.getInt("projectID"));
				project.setProjectName(rs.getString("projectName"));
				project.setStatus(rs.getString("status"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("startDate"));
				project.setFinishDate(rs.getDate("finishDate"));
				project.setViewStatus(rs.getString("viewStatus"));
				projects.add(project);
			}
			rs.close();
			statement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public Project getProjectById(int projectID) {
		Project project = new Project();
		try{
			String query = "select * from project where projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				project.setProjectID(rs.getInt("projectID"));
				project.setProjectName(rs.getString("projectName"));
				project.setStatus(rs.getString("status"));
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("startDate"));
				project.setFinishDate(rs.getDate("finishDate"));
				project.setViewStatus(rs.getString("viewStatus"));
		
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public Project getProjectName(int projectID) {
		Project project = new Project();
		try{
			String query = "select projectName from project where projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				project.setProjectName(rs.getString("projectName"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project;
	}

}
