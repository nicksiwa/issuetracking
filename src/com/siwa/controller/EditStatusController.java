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

import com.siwa.dao.EditStatusDAO;
import com.siwa.dao.EditStatusDAOIM;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.model.Issue;

@WebServlet("/EditStatusController")
public class EditStatusController extends HttpServlet {
	
	private EditStatusDAO dao;
	private IssueDAO dao2;
	private static final long serialVersionUID = 1L;
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";
      
	
    public EditStatusController() {
      dao = new EditStatusDAOIM();
      dao2 = new IssueDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("edit")){
			forward = ISSUE_DETAIL;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = dao.getIsuseStatusById(issueID);
			request.setAttribute("issue", issue);
			request.setAttribute("comments", dao2.getCommentByIssue(issueID));
			
		}else{
			
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
			Date dueDate = new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(request.getParameter("dueDate"));
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
		
		String reporter = (request.getParameter("reporter"));
		reporter = new String(reporter.getBytes("ISO8859-1"), "UTF-8");
		issue.setReporter(reporter);
		
		String issueID = request.getParameter("issueID");
		issue.setIssueID(Integer.parseInt(issueID));
		dao.editIssueStatus(issue);
		
		
		int issueID2 = Integer.parseInt(request.getParameter("issueID"));
		request.setAttribute("issue", issue);
		request.setAttribute("comments", dao2.getCommentByIssue(issueID2));
		
		RequestDispatcher view  = request.getRequestDispatcher(ISSUE_DETAIL);
		request.setAttribute("issue", issue);
		view.forward(request, response);
		
	}

}
