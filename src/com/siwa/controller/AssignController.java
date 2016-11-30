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
import com.siwa.model.Assign;
import com.siwa.model.Project;



@WebServlet("/AssignController")
public class AssignController extends HttpServlet {
	
	private AssignDAO dao;
	private ProjectDAO dao2;
	private static final long serialVersionUID = 1L;
	public static final String LIST_ASSIGN = "/listAssign.jsp";
	public static final String INSERT_OR_EDIT = "/assign.jsp";
	public static final String CONFIG = "/configProject.jsp";
 
    public AssignController() {
    	dao = new AssignDAOImplementation();
    	dao2 = new ProjectDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = CONFIG;
			int assignID = Integer.parseInt(request.getParameter("assignID"));
			
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			
			dao.deleteAssign(assignID);
			
			Project project3 = dao2.getProjectName(projectID);
			Project project2 = dao2.getProjectById(projectID);
			request.setAttribute("project", project3);
			request.setAttribute("project2", project2);
			request.setAttribute("cols",dao2.getCollaborators(projectID));
			request.setAttribute("persons", dao.getPerson());
			
			
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int assignID = Integer.parseInt(request.getParameter("assignID"));
			Assign assign = dao.getAssignById(assignID);
			request.setAttribute("assign", assign);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
			request.setAttribute("projects",dao.getProject());
			request.setAttribute("persons", dao.getPerson());
			
		} else {
			forward = LIST_ASSIGN;
			request.setAttribute("assigns", dao.getAllAssign());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Assign assign = new Assign();
		
		String personName = request.getParameter("personName");
		personName = new String(personName.getBytes("ISO8859-1"), "UTF-8");
		assign.setPersonName(personName);
		
		String projectName = request.getParameter("projectName");
		projectName = new String(projectName.getBytes("ISO8859-1"), "UTF-8");
		assign.setProjectName(projectName);
		
		String assignID = request.getParameter("assignID");
		if(assignID == null || assignID.isEmpty())
			dao.addAssign(assign);
		else{
			assign.setAssignID(Integer.parseInt(assignID));
			dao.updateAssign(assign);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(CONFIG);
		int projectID2 = Integer.parseInt(request.getParameter("projectID"));
		Project project3 = dao2.getProjectName(projectID2);
		Project project2 = dao2.getProjectById(projectID2);
		request.setAttribute("project", project3);
		request.setAttribute("project2", project2);
		request.setAttribute("cols",dao2.getCollaborators(projectID2));
		request.setAttribute("persons", dao.getPerson());
		
		view.forward(request, response);
	}

}
