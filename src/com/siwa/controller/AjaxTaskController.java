package com.siwa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.TaskDAO;
import com.siwa.dao.TaskDAOImplementation;
import com.siwa.model.Issue;
import com.siwa.model.Task;


@WebServlet("/AjaxTaskController")
public class AjaxTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskDAO dao;
    private IssueDAO dao2;

    public AjaxTaskController() {
    	dao = new TaskDAOImplementation();
    	dao2 = new IssueDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String text = "ssssssssssss";

	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(text);       // Write response body.
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
