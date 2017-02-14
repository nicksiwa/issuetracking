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
import javax.servlet.http.HttpSession;

import com.siwa.dao.AssignDAO;
import com.siwa.dao.AssignDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Assign;
import com.siwa.model.Project;

@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {

	private ProjectDAO dao;
	private AssignDAO dao2;
	private IssueDAO dao3;
	private static final long serialVersionUID = 1L;
	public static final String LIST_PROJECT = "/listProject.jsp";
	public static final String INSERT_OR_EDIT = "/project.jsp";
	public static final String MANAGE = "/projectManage.jsp";
	public static final String CONFIG = "/configProject.jsp";
	public static final String MAIN = "/projectMain.jsp";
	public static final String TASK = "/projectTask.jsp";
	public static final String GRAPH = "/projectGraph.jsp";
	public static final String MILE = "/milestone.jsp";
	public static final String LABEL = "/projectLabels.jsp";
	public static final String GITHUB = "/projectGitHub.jsp";

	public ProjectController() {
		dao = new ProjectDAOImplementation();
		dao2 = new AssignDAOImplementation();
		dao3 = new IssueDAOImplementation();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = MANAGE;
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
		} else if (action.equalsIgnoreCase("manage")) {
			forward = MANAGE;
			request.setAttribute("projects", dao.getAllProjects());
		} else if (action.equalsIgnoreCase("config")) {
			forward = CONFIG;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectName(projectID);
			Project project2 = dao.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("project2", project2);
			request.setAttribute("cols", dao.getCollaborators(projectID));
			request.setAttribute("persons", dao2.getPerson());

			HttpSession session = request.getSession();
			String user = (String) session.getAttribute("username");

			request.setAttribute("assignResolved", dao.getIssueByAssignResolved(projectID, user));
			request.setAttribute("assignNo", dao.getIssueByAssign(projectID, user));
			request.setAttribute("unassign", dao.getIssueByUnAssign(projectID));
			request.setAttribute("unassignResolved", dao.getIssueByUnAssignResolved(projectID));
			request.setAttribute("issueUn", dao.getAllIssue(projectID));
			request.setAttribute("issueResolved", dao.getAllIssueByResolved(projectID));
		} else if (action.equalsIgnoreCase("main")) {
			forward = MAIN;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		} 
		else if(action.equalsIgnoreCase("task")){
			forward = TASK;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		}
		else if(action.equalsIgnoreCase("graph")){
			forward = GRAPH;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		}
		else if(action.equalsIgnoreCase("milestone")){
			forward = MILE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		}
		else if(action.equalsIgnoreCase("label")){
			forward = LABEL;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		}
		else if(action.equalsIgnoreCase("github")){
			forward = GITHUB;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao.getProjectById(projectID);
			request.setAttribute("project", project);
		}
		else {
			forward = MANAGE;
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
			Date startDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(request.getParameter("startDate"));
			project.setStartDate(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			Date finishDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(request.getParameter("finishDate"));
			project.setFinishDate(finishDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String viewStatus = (request.getParameter("viewStatus"));
		viewStatus = new String(viewStatus.getBytes("ISO8859-1"), "UTF-8");
		project.setViewStatus(viewStatus);

		String projectID = request.getParameter("projectID");

		if (projectID == null || projectID.isEmpty())
			dao.addProject(project);

		else {
			project.setProjectID(Integer.parseInt(projectID));
			dao.updateProject(project);
		}

		RequestDispatcher view = request.getRequestDispatcher(MANAGE);
		request.setAttribute("projects", dao.getAllProjects());
		view.forward(request, response);

	}
}
