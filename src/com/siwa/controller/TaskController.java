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

import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.dao.TaskDAO;
import com.siwa.dao.TaskDAOImplementation;
import com.siwa.model.Project;
import com.siwa.model.Task;


@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskDAO dao;
    private ProjectDAO dao2;
    
    public static final String TASK = "/projectTask.jsp";

    public TaskController() {
    	dao = new TaskDAOImplementation();
    	dao2 = new ProjectDAOImplementation();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = TASK;
			int taskID = Integer.parseInt(request.getParameter("taskID"));
			dao.deleteTask(taskID);
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("tasks", dao.getAllTaskByProjectId(projectID));
			
		}else if(action.equalsIgnoreCase("insert")){
			forward = TASK;
			
		}
		else if(action.equalsIgnoreCase("task")){
			forward = TASK;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("tasks", dao.getAllTaskByProjectId(projectID));
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
		
		int taskType = Integer.parseInt(request.getParameter("taskType"));
		task.setTaskType(taskType);
		
		try {
			Timestamp createDate = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("createDate"));
			task.setCreateDate(createDate);
		} catch (ParseException e) {
		
		}
		
		String createBy = username;
		createBy = new String(createBy.getBytes("ISO8859-1"), "UTF-8");
		task.setCreateBy(createBy);
		
		int taskProject = Integer.parseInt((request.getParameter("projectID")));
		task.setTaskProject(taskProject);
		
		String taskID = request.getParameter("taskID");
		if(taskID == null || taskID.isEmpty()){
			dao.addTask(task);
		}else{
			task.setTaskID(Integer.parseInt(taskID));
			dao.updateTask(task);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(TASK);
		int projectID = Integer.parseInt(request.getParameter("projectID"));
		Project project = dao2.getProjectById(projectID);
		request.setAttribute("project", project);
		request.setAttribute("tasks", dao.getAllTaskByProjectId(projectID));
		view.forward(request, response);
	}

}
