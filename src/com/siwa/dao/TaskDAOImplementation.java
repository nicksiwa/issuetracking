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
			String query = "insert into task (taskDetail, taskType, createDate, createBy) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, task.getTaskDetail());
			ps.setInt(2, task.getTaskType());
			ps.setTimestamp(3, new Timestamp(date.getTime()));
			ps.setString(4, task.getCreateBy());
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
		java.util.Date date= new java.util.Date();
		try{
			String query = "update task set taskDetail=?, taskType=?, createDate=?, createBy=? where taskID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, task.getTaskDetail());
			ps.setInt(2, task.getTaskType());
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

}
