package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Issue;
import com.siwa.model.Task;
import com.siwa.util.DBUtil;

public class TaskDAOImplementation implements TaskDAO {
	
	private Connection conn;

	public TaskDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addTask(Task task) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "insert into task (taskDetail, taskType, createDate, createBy, taskProject) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, task.getTaskDetail());
			ps.setInt(2, task.getTaskType());
			ps.setTimestamp(3, new Timestamp(date.getTime()));
			ps.setString(4, task.getCreateBy());
			ps.setInt(5, task.getTaskProject());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTask(int taskID) {
		try{
			String query = "delete from task where taskID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, taskID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTask(Task task) {

		try{
			String query = "update task set taskType=? where taskID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, task.getTaskType());
			ps.setInt(2, task.getTaskID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from task");
			while(rs.next()){
				Task task = new Task();
				task.setTaskID(rs.getInt("taskID"));
				task.setTaskDetail(rs.getString("taskDetail"));
				task.setTaskType(rs.getInt("taskType"));
				task.setCreateBy(rs.getString("createBy"));
				tasks.add(task);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public List<Task> getAllTaskByProjectId(int projectID) {
		List<Task> tasks = new ArrayList<Task>();
		try{
			String query = "select * from task where taskProject=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Task task = new Task();
				task.setTaskID(rs.getInt("taskID"));
				task.setTaskDetail(rs.getString("taskDetail"));
				task.setTaskType(rs.getInt("taskType"));
				task.setCreateBy(rs.getString("createBy"));
				task.setTaskProject(rs.getInt("taskProject"));
				task.setCreateDate(rs.getTimestamp("createDate"));
				tasks.add(task);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public void testTask(Task task) {
		try{

			String query = "INSERT INTO project (projectName,projectType,owner) SELECT * FROM (SELECT ?,?,?) AS tmp WHERE NOT EXISTS (SELECT projectName FROM project WHERE projectName = ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, task.getTaskDetail());
			ps.setString(2, "GitHub");
			ps.setString(3, task.getCreateBy());
			ps.setString(4, task.getTaskDetail());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
