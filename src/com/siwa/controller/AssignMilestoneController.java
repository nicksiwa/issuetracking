package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.AssignMilestoneDAO;
import com.siwa.dao.AssignMilestoneDAOImplementation;
import com.siwa.model.AssignMilestone;


@WebServlet("/AssignMilestoneController")
public class AssignMilestoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DETAIL = "/issueDetail.jsp";
    private AssignMilestoneDAO dao;
       

    public AssignMilestoneController() {
       dao = new AssignMilestoneDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = DETAIL;
		}else if(action.equalsIgnoreCase("insert")){
			forward = DETAIL;
		}else{
			forward = DETAIL;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssignMilestone assignMilestone = new AssignMilestone();
		
		String milestoneName = request.getParameter("milestoneName");
		milestoneName = new String(milestoneName.getBytes("ISO8859-1"), "UTF-8");
		assignMilestone.setMilestoneName(milestoneName);
		
		int issueID = Integer.parseInt(request.getParameter("issueID"));
		assignMilestone.setIssueID(issueID);
		
		String assignMilestoneID = request.getParameter("assignMilestoneID");
		if(assignMilestoneID == null || assignMilestoneID.isEmpty())
			dao.addAssignMilestone(assignMilestone);
		else{
			
		}
		RequestDispatcher view = request.getRequestDispatcher(DETAIL);
		
		view.forward(request, response);
	}

}
