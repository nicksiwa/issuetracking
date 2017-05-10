package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Milestone;
import com.siwa.model.Project;


@WebServlet("/MilestoneController")
public class MilestoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MilestoneDAO dao;
    private ProjectDAO dao2;
    private IssueDAO dao3;
    public static final String MILE = "/milestone.jsp";

    public MilestoneController() {
      dao = new MilestoneDAOImplementation();
      dao2 = new ProjectDAOImplementation();
      dao3 = new IssueDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = MILE;
			int milestoneID = Integer.parseInt(request.getParameter("milestoneID"));
			dao.deleteMilestone(milestoneID);
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("milestones", dao.getAllMilestoneByProjectId(projectID));
			request.setAttribute("percent", dao3.getMilestonePercent(projectID));
			request.setAttribute("percentClosed", dao3.geetMilestoneClosedPercent(projectID));
		}else if(action.equalsIgnoreCase("insert")){
			forward = MILE;
		}else if(action.equalsIgnoreCase("milestone")){
			forward = MILE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("milestones", dao.getAllMilestoneByProjectId(projectID));
			request.setAttribute("percent", dao3.getMilestonePercent(projectID));
			request.setAttribute("percentClosed", dao3.geetMilestoneClosedPercent(projectID));
		

		}else{
			forward = MILE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("milestones", dao.getAllMilestoneByProjectId(projectID));
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Milestone milestone = new Milestone();
		
		String milestoneName = (request.getParameter("milestoneName"));
		milestoneName = new String(milestoneName.getBytes("ISO8859-1"), "UTF-8");
		milestone.setMilestoneName(milestoneName);
		
		String milestoneDescription = (request.getParameter("milestoneDescription"));
		milestoneDescription = new String(milestoneDescription.getBytes("ISO8859-1"), "UTF-8");
		milestone.setMilestoneDescription(milestoneDescription);
		
		int milestoneProject = Integer.parseInt((request.getParameter("projectID")));
		milestone.setMilestoneProject(milestoneProject);
		
		String milestoneID = request.getParameter("milestoneID");
		if(milestoneID == null || milestoneID.isEmpty()){
			dao.addMilestone(milestone);
		}else{
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(MILE);
		int projectID = Integer.parseInt(request.getParameter("projectID"));
		Project project = dao2.getProjectById(projectID);
		request.setAttribute("project", project);
		request.setAttribute("milestones", dao.getAllMilestoneByProjectId(projectID));
		request.setAttribute("percent", dao3.getMilestonePercent(projectID));
		request.setAttribute("percentClosed", dao3.geetMilestoneClosedPercent(projectID));
		view.forward(request, response);
	}

}
