package com.siwa.controller;

import java.io.IOException;
import java.sql.Timestamp;
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



import com.siwa.dao.IndexDAO;
import com.siwa.dao.IndexDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Comment;
import com.siwa.model.Issue;
import com.siwa.model.Project;



@WebServlet("/IssueController")
public class IssueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IssueDAO dao;
	private ProjectDAO dao2;
	private IndexDAO dao3;
	
	public static final String LIST_ISSUE = "/listIssue.jsp";
	public static final String INSERT_OR_EDIT = "/issue.jsp";
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";
	public static final String ISSUE_BY_PROJECT = "/issueByProject.jsp";
	public static final String REPORT = "/reportMeList.jsp";
	
	
    public IssueController() {
       dao = new IssueDAOImplementation();
       dao2 = new ProjectDAOImplementation();
       dao3 = new IndexDAOImplementation();
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
			request.setAttribute("issuess", dao.getPersonByProject(issueID));
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
			
			int projectID = Integer.parseInt(request.getParameter("project"));
			Project project = dao2.getProjectName(projectID);
			request.setAttribute("project", project);

			request.setAttribute("issuess", dao.getPersonByProject(projectID));
			
		}else if (action.equalsIgnoreCase("detail")){
			forward  = ISSUE_DETAIL;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = dao.getAssignById(issueID);
			request.setAttribute("issue", issue);
			
			request.setAttribute("comments", dao.getCommentByIssue(issueID));
		}
		else if (action.equalsIgnoreCase("project")){
			forward = ISSUE_BY_PROJECT;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			request.setAttribute("projects", dao.getIssueByProject(projectID));
		}
		else {
			forward = LIST_ISSUE;
			request.setAttribute("issues", dao.getAllIssue());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Issue issue = new Issue();
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
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
		
		
		try {
			Timestamp updateDate = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("updateDate"));
			issue.setUpdateDate(updateDate);
		} catch (ParseException e) {
			
		}
		
		
		
		
		
		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		issue.setStatus(status);
		
		
		
		
		String reporter = username;
		reporter = new String(reporter.getBytes("ISO8859-1"), "UTF-8");
		issue.setReporter(reporter);
		
		String issueID = request.getParameter("issueID");
		if(issueID == null || issueID.isEmpty())
			dao.addIssue(issue);
		else{
			issue.setIssueID(Integer.parseInt(issueID));
			dao.updateIssue(issue);
		}
		RequestDispatcher view = request.getRequestDispatcher(REPORT);
		request.setAttribute("reports", dao3.getReportByMe(username));
		view.forward(request, response);
	}

}
