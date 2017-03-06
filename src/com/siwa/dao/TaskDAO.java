package com.siwa.dao;

import java.util.List;

import com.siwa.model.Task;

public interface TaskDAO {
	public void addTask(Task task);

	public void deleteTask(int taskID);

	public void updateTask(Task task);
	
	public List<Task> getAllTasks();
	
	public List<Task> getAllTaskByProjectId(int projectID);
}
