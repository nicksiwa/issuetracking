package com.siwa.dao;

import java.util.List;

import com.siwa.model.Assign;
import com.siwa.model.Issue;
import com.siwa.model.Person;
import com.siwa.model.Project;

public interface ProjectDAO {
	public void addProject(Project project);

	public void deleteProject(int projectID);

	public void updateProject(Project project);

	public List<Project> getAllProjects();

	public Project getProjectById(int projectID);
	
	public Project getProjectName(int projectID);
	
	public List<Assign> getPerson();
	
	public void addCollaborators(Assign assign);
	
	public List<Person> getCollaborators(int projectID);
	
	public void configProject(Project project);
	
	public List<Issue> getIssueByAssignResolved(int projectID,String user);
	
	public List<Issue> getIssueByAssign(int projectID,String user);
	
	public List<Issue> getIssueByUnAssign(int projectID);
	
	public List<Issue> getIssueByUnAssignResolved(int projectID);
	
	public List<Issue> getAllIssue(int projectID);
	
	public List<Issue> getAllIssueByResolved(int projectID);
	
}
