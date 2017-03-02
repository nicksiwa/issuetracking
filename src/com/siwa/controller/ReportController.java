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
import com.siwa.dao.ReportDAO;
import com.siwa.dao.ReportDAOImplementtation;
import com.siwa.model.Issue;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IssueDAO dao;
    public static final String ISSUE_DETAIL = "/issueDetail.jsp";
    public static final String LIST_ISSUE = "/listIssue.jsp";
    public ReportController() {
        dao=new IssueDAOImplementation();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("severity")){
			
		}else{
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Issue issue = new Issue();
		
		
		String severity = (request.getParameter("severity"));
		severity = new String(severity.getBytes("ISO8859-1"), "UTF-8");
		issue.setSeverity(severity);
		
		
		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		issue.setStatus(status);
		
		String firstDate = (request.getParameter("firstDate"));
		firstDate = new String(firstDate.getBytes("ISO8859-1"), "UTF-8");
		issue.setAssign(firstDate);
		
		String secondDate = (request.getParameter("secondDate"));
		secondDate = new String(secondDate.getBytes("ISO8859-1"), "UTF-8");
		issue.setDescription(secondDate);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_ISSUE);
		request.setAttribute("issues", dao.getReport(severity, status, firstDate+" 00:00:00.00", secondDate+" 23:59:59.999"));
		view.forward(request, response);
		
	}

}
