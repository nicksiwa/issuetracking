package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Assign;
import com.siwa.model.Issue;
import com.siwa.model.Person;
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
			String query = "insert into project (projectName, status, description, startDate, finishDate, viewStatus, owner) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getStatus());
			ps.setString(3, project.getDescription());
			ps.setDate(4,new java.sql.Date( project.getStartDate().getTime()));
			ps.setDate(5,new java.sql.Date( project.getFinishDate().getTime()));
			ps.setString(6, project.getViewStatus());
			ps.setString(7, project.getOwner());
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
				project.setProjectType(rs.getString("projectType"));
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
				project.setOwner(rs.getString("owner"));
		
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
			String query = "select projectName,projectID from project where projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				project.setProjectID(rs.getInt("projectID"));
				project.setProjectName(rs.getString("projectName"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project;
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

	@Override
	public void addCollaborators(Assign assign) {
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
	public List<Person> getCollaborators(int projectID) {
		List<Person> cols = new ArrayList<Person>();
		try{
			String query = "select person.firstName,person.lastName,person.position,assign.assignID,project.projectID from person join assign on person.personId = assign.person_ID join project on assign.project_ID = project.projectID and project.projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Person person = new Person();
				person.setFirstName(rs.getString("firstName"));
				person.setLastName(rs.getString("lastName"));
				person.setPosition(rs.getString("position"));
				person.setAssignID(rs.getInt("assignID"));
				person.setProjectID(rs.getInt("projectID"));
				cols.add(person);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cols;
	}

	@Override
	public void configProject(Project project) {
		try{
			String query = "update project set status=?, viewStatus=? where projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, project.getStatus());
			ps.setString(2, project.getViewStatus());
			ps.setInt(3, project.getProjectID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Issue> getIssueByAssignResolved(int projectID,String user) {
		List<Issue> assignResolved = new ArrayList<Issue>();
		try{
			String query = "select issue.title,issue.`status` from issue join project on issue.project = project.projectName where issue.`status` = 'Resolved' and project.projectID=? and issue.assign=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ps.setString(2, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setTitle(rs.getString("title"));
				assignResolved.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return assignResolved;
	}

	@Override
	public List<Issue> getIssueByAssign(int projectID,String user) {
		List<Issue> assignNo = new ArrayList<Issue>();
		try{
			String query = "select issue.title,issue.`status` from issue join project on issue.project = project.projectName where issue.`status` != 'Resolved' and project.projectID=? and issue.assign=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ps.setString(2, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setTitle(rs.getString("title"));
				assignNo.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return assignNo;
	}

	@Override
	public List<Issue> getIssueByUnAssign(int projectID) {
		List<Issue> unassign = new ArrayList<Issue>();
		try{
			String query = "select issue.title,issue.`status` from issue join project on issue.project = project.projectName where issue.`status` != 'Resolved' and project.projectID=? and issue.assign='-'";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setTitle(rs.getString("title"));
				unassign.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return unassign;
	}

	@Override
	public List<Issue> getIssueByUnAssignResolved(int projectID) {
		List<Issue> unassignResolved = new ArrayList<Issue>();
		try{
			String query = "select issue.title,issue.`status` from issue join project on issue.project = project.projectName where issue.`status` = 'Resolved' and project.projectID=? and issue.assign='-'";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setTitle(rs.getString("title"));
				unassignResolved.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return unassignResolved;
	}

	@Override
	public List<Issue> getAllIssue(int projectID) {
		List<Issue> issueUn = new ArrayList<Issue>();
		try{
			String query = "select issue.title,issue.`status` from issue join project on issue.project = project.projectName where issue.`status` != 'Resolved' and project.projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setTitle(rs.getString("title"));
				issueUn.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issueUn;
	}

	@Override
	public List<Issue> getAllIssueByResolved(int projectID) {
		List<Issue> issueResolved = new ArrayList<Issue>();
		try{
			String query = "select issue.title,issue.`status` from issue join project on issue.project = project.projectName where issue.`status` = 'Resolved' and project.projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setTitle(rs.getString("title"));
				issueResolved.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issueResolved;
	}

	@Override
	public List<Project> getProjectsByUser(String username) {
		List<Project> projects = new ArrayList<Project>();
		try{
			String query = "select project.status, project.projectName, project.projectID, project.projectType, project.`owner`,project.description from project where project.`owner` in (?) UNION select project.status, project.projectName, project.projectID, project.projectType, project.`owner`,project.description from person JOIN assign on person.personId = assign.person_ID and CONCAT_WS (' ',firstName, lastName) like ? JOIN project on assign.project_ID = project.projectID";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Project project = new Project();
				project.setProjectID(rs.getInt("projectID"));
				project.setProjectName(rs.getString("projectName"));
				project.setStatus(rs.getString("status"));
				project.setProjectType(rs.getString("projectType"));
				project.setDescription(rs.getString("description"));
				projects.add(project);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		
		return projects;
	}

	@Override
	public List<Project> getOwnerName() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
