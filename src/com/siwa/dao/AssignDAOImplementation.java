package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Assign;
import com.siwa.util.DBUtil;

public class AssignDAOImplementation implements AssignDAO{

	private Connection conn;

	public AssignDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addAssign(Assign assign) {
		try{
			String query = "set @person_id = (select person.personId from person where person.firstName = ?)";
			String query2 = "set @project_id = (select project.projectID from project where project.projectName = ?)";
			String query3 = "insert into assign (person_ID,project_ID) values (@person_id,@project_id)";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps2 = conn.prepareStatement(query2);
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps.setString(1, assign.getPersonName());
			ps2.setString(1, assign.getProjectName());
			ps.executeQuery();
			ps2.executeQuery();
			ps3.executeUpdate();
			ps.close();
			ps2.close();
			ps3.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAssign(int assignID) {
		try{
			String query = "delete from assign where assignID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, assignID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAssign(Assign assign) {
		try{
			String query = "update assign set person_ID=?, project_ID=? where assignID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, assign.getPersonID());
			ps.setInt(2, assign.getProjectID());
			ps.setInt(3, assign.getAssignID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Assign> getAllAssign() {
		List<Assign> assigns = new ArrayList<Assign>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from assign");
			while(rs.next()){
				Assign assign = new Assign();
				assign.setAssignID(rs.getInt("assignID"));
				assign.setPersonID(rs.getInt("person_ID"));
				assign.setProjectID(rs.getInt("project_ID"));
				assigns.add(assign);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return assigns;
	}

	@Override
	public Assign getAssignById(int assignID) {
		Assign assign = new Assign();
		try{
			String query = "select * from assign where assignID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, assignID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				assign.setAssignID(rs.getInt("assignID"));
				assign.setPersonID(rs.getInt("person_ID"));
				assign.setProjectID(rs.getInt("project_ID"));
			}
			ps.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return assign;
	}
	
	
	@Override
	public List<Assign> getProject() {
		List<Assign> projects = new ArrayList<Assign>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select projectName from project");
			while(rs.next()){
				Assign assign = new Assign();
				assign.setProjectName(rs.getString("projectName"));
				projects.add(assign);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return projects;
	}
	
	
	@Override
	public List<Assign> getPerson() {
		List<Assign> persons = new ArrayList<Assign>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select firstName from person");
			while(rs.next()){
				Assign assign = new Assign();
				assign.setPersonName(rs.getString("firstName"));
				persons.add(assign);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return persons;
	}

}
