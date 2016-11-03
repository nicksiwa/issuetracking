package com.siwa.dao;

import java.util.List;

import com.siwa.model.Project;

public interface ProjectDAO {
	public void addProject(Project project);

	public void deleteProject(int projectID);

	public void updateProject(Project project);

	public List<Project> getAllProjects();

	public Project getProjectById(int projectID);
	
	public Project getProjectName(int projectID);
}
