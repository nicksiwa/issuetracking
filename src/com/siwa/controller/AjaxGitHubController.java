package com.siwa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.TaskDAO;
import com.siwa.dao.TaskDAOImplementation;
import com.siwa.model.Task;


@WebServlet("/AjaxGitHubController")
public class AjaxGitHubController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaskDAO dao;

    public AjaxGitHubController() {
        dao = new TaskDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = new Task();
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		dao.getAllTasks();
		String A = request.getParameter("A");
		task.setTaskDetail(A);
		String B = username;
		task.setCreateBy(B);
		dao.testTask(task);
		
	}

}
