package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.AssignLabelDAO;
import com.siwa.dao.AssignLabelDAOImplementation;
import com.siwa.model.AssignLabel;


@WebServlet("/AssignLabelController")
public class AssignLabelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DETAIL = "/issueDetail.jsp";
    private AssignLabelDAO dao;
  
    public AssignLabelController() {
       dao = new AssignLabelDAOImplementation();
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
		AssignLabel assignlabel = new AssignLabel();
	
		String labelName = request.getParameter("labelName");
		labelName = new String(labelName.getBytes("ISO8859-1"), "UTF-8");
		assignlabel.setLabelName(labelName);
		
		
		int issueID = Integer.parseInt(request.getParameter("issueID"));
		assignlabel.setIssueID(issueID);
		
		String assignLabelID = request.getParameter("assignLabelID");
		if(assignLabelID == null || assignLabelID.isEmpty())
			dao.addAssignLabel(assignlabel);
		else{
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(DETAIL);
		
		view.forward(request, response);
	}

}
