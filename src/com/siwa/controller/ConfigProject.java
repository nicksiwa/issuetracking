package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.AssignDAO;
import com.siwa.dao.AssignDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Project;


@WebServlet("/ConfigProject")
public class ConfigProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO dao;
	private AssignDAO dao2;
	public static final String CONFIG = "/configProject.jsp";
	public static final String MANAGE = "/projectManage.jsp";


    public ConfigProject() {
		dao = new ProjectDAOImplementation();
		dao2 = new AssignDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Project project = new Project();
		
		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		project.setStatus(status);
		
		String viewStatus = (request.getParameter("viewStatus"));
		viewStatus = new String(viewStatus.getBytes("ISO8859-1"), "UTF-8");
		project.setViewStatus(viewStatus);
		
		String projectID = request.getParameter("projectID");
		
		if (projectID == null || projectID.isEmpty())
			dao.addProject(project);
		
		else {
			project.setProjectID(Integer.parseInt(projectID));
			dao.configProject(project);
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(CONFIG);
		
		int projectID2 = Integer.parseInt(request.getParameter("projectID"));
		Project project3 = dao.getProjectName(projectID2);
		Project project2 = dao.getProjectById(projectID2);
		request.setAttribute("project", project3);
		request.setAttribute("project2", project2);
		request.setAttribute("cols",dao.getCollaborators(projectID2));
		request.setAttribute("persons", dao2.getPerson());
		view.forward(request, response);
	}

}
