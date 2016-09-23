package com.siwa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Project;

@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	
	private ProjectDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_PROJECT = "/listProject.jsp";
	public static final String INSERT_OR_EDIT = "/project.jsp";

	public ProjectController() {
		dao = new ProjectDAOImplementation();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_PROJECT;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			dao.deleteProject(projectID);
			request.setAttribute("projects", dao.getAllProjects());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else {
			forward = LIST_PROJECT;
			request.setAttribute("projects", dao.getAllProjects());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Project project = new Project();

		String projectName = (request.getParameter("projectName"));
		projectName = new String(projectName.getBytes("ISO8859-1"), "UTF-8");
		project.setProjectName(projectName);

		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		project.setStatus(status);

		String description = (request.getParameter("description"));
		description = new String(description.getBytes("ISO8859-1"), "UTF-8");
		project.setDescription(description);

		try {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
			project.setStartDate(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			Date finishDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finishDate"));
			project.setFinishDate(finishDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		String projectID = request.getParameter("projectID");

		if (projectID == null || projectID.isEmpty())
			dao.addProject(project);
		else {
			project.setProjectID(Integer.parseInt(projectID));
			dao.updateProject(project);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_PROJECT);
		request.setAttribute("projects", dao.getAllProjects());
		view.forward(request, response);
	}
}
