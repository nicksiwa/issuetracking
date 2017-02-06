package com.siwa.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.TaskDAO;
import com.siwa.dao.TaskDAOImplementation;
import com.siwa.model.Task;


@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskDAO dao;
    
    public static final String TASK = "/projectTask.jsp";

    public TaskController() {
    	dao = new TaskDAOImplementation();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = TASK;
			int taskID = Integer.parseInt(request.getParameter("taskID"));
			dao.deleteTask(taskID);
			request.setAttribute("tasks", dao.getAllTasks());
			
		}else if(action.equalsIgnoreCase("insert")){
			forward = TASK;
			
		}
		else if(action.equalsIgnoreCase("task")){
			forward = TASK;
			request.setAttribute("tasks", dao.getAllTasks());
		}
		else{
			forward = TASK;
			request.setAttribute("tasks", dao.getAllTasks());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String taskDetail = (request.getParameter("taskDetail"));
		taskDetail = new String(taskDetail.getBytes("ISO8859-1"), "UTF-8");
		task.setTaskDetail(taskDetail);
		
		try {
			Timestamp createDate = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("createDate"));
			task.setCreateDate(createDate);
		} catch (ParseException e) {
		
		}
		
		String createBy = username;
		createBy = new String(createBy.getBytes("ISO8859-1"), "UTF-8");
		task.setCreateBy(createBy);
		
		String taskID = request.getParameter("taskID");
		if(taskID == null || taskID.isEmpty()){
			dao.addTask(task);
		}else{
			task.setTaskID(Integer.parseInt(taskID));
			dao.updateTask(task);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(TASK);
		request.setAttribute("tasks", dao.getAllTasks());
		view.forward(request, response);
	}

}
