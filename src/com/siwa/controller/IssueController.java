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

import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.model.Issue;


@WebServlet("/IssueController")
public class IssueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IssueDAO dao;
	public static final String LIST_ISSUE = "/listIssue.jsp";
	public static final String INSERT_OR_EDIT = "/issue.jsp";
	
	
    public IssueController() {
       dao = new IssueDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_ISSUE;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			dao.deleteIssue(issueID);
			request.setAttribute("issues", dao.getAllIssue());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = dao.getAssignById(issueID);
			request.setAttribute("issue", issue);
			request.setAttribute("issuess", dao.getPersonAndProject());
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
			request.setAttribute("issuess", dao.getPersonAndProject());
			
		} else {
			forward = LIST_ISSUE;
			request.setAttribute("issues", dao.getAllIssue());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Issue issue = new Issue();
		
		String project = (request.getParameter("project"));
		project = new String(project.getBytes("ISO8859-1"), "UTF-8");
		issue.setProject(project);
		
		
		
		String assign = (request.getParameter("assign"));
		assign = new String(assign.getBytes("ISO8859-1"), "UTF-8");
		issue.setAssign(assign);
		
		String title = (request.getParameter("title"));
		title = new String(title.getBytes("ISO8859-1"), "UTF-8");
		issue.setTitle(title);
		
		String description = (request.getParameter("description"));
		description = new String(description.getBytes("ISO8859-1"), "UTF-8");
		issue.setDescription(description);
		
		String severity = (request.getParameter("severity"));
		severity = new String(severity.getBytes("ISO8859-1"), "UTF-8");
		issue.setSeverity(severity);
		
		String priority = (request.getParameter("priority"));
		priority = new String(priority.getBytes("ISO8859-1"), "UTF-8");
		issue.setPriority(priority);
		
		try {
			Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dueDate"));
			issue.setDueDate(dueDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String updateDate = (request.getParameter("updateDate"));
		updateDate = new String(updateDate.getBytes("ISO8859-1"), "UTF-8");
		issue.setUpdateDate(updateDate);
		
		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		issue.setStatus(status);
		
		String issueID = request.getParameter("issueID");
		if(issueID == null || issueID.isEmpty())
			dao.addIssue(issue);
		else{
			issue.setIssueID(Integer.parseInt(issueID));
			dao.updateIssue(issue);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_ISSUE);
		request.setAttribute("issues", dao.getAllIssue());
		view.forward(request, response);
	}

}
