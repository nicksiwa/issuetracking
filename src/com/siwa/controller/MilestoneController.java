package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.model.Milestone;


@WebServlet("/MilestoneController")
public class MilestoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MilestoneDAO dao;
    public static final String MILE = "/milestone.jsp";

    public MilestoneController() {
      dao = new MilestoneDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = MILE;
		}else if(action.equalsIgnoreCase("insert")){
			forward = MILE;
		}else if(action.equalsIgnoreCase("milestone")){
			forward = MILE;
			request.setAttribute("milestones", dao.getAllMilestone());
		}else{
			forward = MILE;
			request.setAttribute("milestones", dao.getAllMilestone());
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
		
		String milestoneID = request.getParameter("milestoneID");
		if(milestoneID == null || milestoneID.isEmpty()){
			dao.addMilestone(milestone);
		}else{
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(MILE);
		request.setAttribute("milestones", dao.getAllMilestone());
		view.forward(request, response);
	}

}
