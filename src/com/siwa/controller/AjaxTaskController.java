package com.siwa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.TaskDAO;
import com.siwa.dao.TaskDAOImplementation;
import com.siwa.model.Task;


@WebServlet("/AjaxTaskController")
public class AjaxTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskDAO dao;

    public AjaxTaskController() {
    	dao = new TaskDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		
		int taskType = Integer.parseInt(request.getParameter("taskType"));
		task.setTaskType(taskType);
		
		String taskID = request.getParameter("taskID");
		if(taskID == null || taskID.isEmpty()){
			dao.addTask(task);
		}else{
			task.setTaskID(Integer.parseInt(taskID));
			dao.updateTask(task);
		}
	}

}
