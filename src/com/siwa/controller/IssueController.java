package com.siwa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.FileDAO;
import com.siwa.dao.FileDAOImplementation;
import com.siwa.dao.IndexDAO;
import com.siwa.dao.IndexDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.dao.ReportDAO;
import com.siwa.dao.ReportDAOImplementation;
import com.siwa.model.Comment;
import com.siwa.model.File;
import com.siwa.model.Issue;
import com.siwa.model.Person;
import com.siwa.model.Project;

@WebServlet("/IssueController")
public class IssueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IssueDAO dao;
	private ProjectDAO dao2;
	private IndexDAO dao3;
	private LabelDAO dao4;
	private MilestoneDAO dao5;
	private ReportDAO dao6;
	private FileDAO dao7;

	public static final String LIST_ISSUE = "/listIssue.jsp";
	public static final String LIST_ISSUE_SORT_ID = "/listIssueSortID.jsp";
	public static final String INSERT_OR_EDIT = "/issue.jsp";
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";
	public static final String ISSUE_BY_PROJECT = "/issueByProject.jsp";
	public static final String REPORT = "/reportMeList.jsp";
	public static final String ISSUE_DETAIL_CLOSED = "/reopen.jsp";
	public static final String CLOSED = "/issueClosed.jsp";

	public IssueController() {
		dao = new IssueDAOImplementation();
		dao2 = new ProjectDAOImplementation();
		dao3 = new IndexDAOImplementation();
		dao4 = new LabelDAOImplementation();
		dao5 = new MilestoneDAOImplementation();
		dao6 = new ReportDAOImplementation();
		dao7 = new FileDAOImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
        int recordsPerPage = 10;
        if(request.getParameter("page") != null){
        	page = Integer.parseInt(request.getParameter("page"));
        }
        
		
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (action.equalsIgnoreCase("delete")) {
			forward = CLOSED;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			dao.deleteIssue(issueID);
			request.setAttribute("issues", dao.getAllIssueClosed());
			request.setAttribute("label", dao3.getLabelByIssueId(username));
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
			Issue issue = dao.getEmailByUsername(username);
			request.setAttribute("issue", issue);

		} else if (action.equalsIgnoreCase("detail")) {
			forward = ISSUE_DETAIL;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = dao.getAssignById(issueID);
			request.setAttribute("issue", issue);			
			request.setAttribute("labels", dao4.getAllLabelByIssueID(issueID));
			request.setAttribute("labelAssigns", dao4.getAssignLabel(issueID));
			request.setAttribute("milestones", dao5.getMilestoneByIssueId(issueID));
			request.setAttribute("milestoneAssigns", dao5.getAssignMilestone(issueID));
			request.setAttribute("comments", dao.getCommentByIssue(issueID));
			request.setAttribute("files", dao7.getAllFileByIssueId(issueID));
			
		} else if (action.equalsIgnoreCase("project")) {
			forward = ISSUE_BY_PROJECT;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			request.setAttribute("projects", dao.getIssueByProject(projectID));
		} else if (action.equalsIgnoreCase("closed")) {
			forward = ISSUE_DETAIL_CLOSED;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = dao.getAssignById(issueID);
			request.setAttribute("issue", issue);
			request.setAttribute("labels", dao4.getAllLabelByIssueID(issueID));
			request.setAttribute("labelAssigns", dao4.getAssignLabel(issueID));
			request.setAttribute("milestones", dao5.getMilestoneByIssueId(issueID));
			request.setAttribute("milestoneAssigns", dao5.getAssignMilestone(issueID));
			request.setAttribute("comments", dao.getCommentByIssue(issueID));
			request.setAttribute("files", dao7.getAllFileByIssueId(issueID));
			
			String assignusername = issue.getAssign();
			Issue email = dao.getEmailByUsername(assignusername);			
			String to = email.getEmail_id();
		    String subject = "Issue assign to you has been closed";
		    String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+issue.getTitle()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+issue.getDescription()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+issue.getSeverity()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+issue.getPriority()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+issue.getDueDate()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+issue.getStatus()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+issue.getReporter()+"</td></tr></table>";
		    String user = "the.issue.tracking@gmail.com";
		    String pass = "niksf203";
		    SendMail.send(to,subject, message, user, pass);
		} else if (action.equalsIgnoreCase("test")) {
			forward = LIST_ISSUE;
		} 
		else if(action.equalsIgnoreCase("severity")){
			forward = ISSUE_DETAIL;
			
		}else if(action.equalsIgnoreCase("issueId")){
			forward = LIST_ISSUE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
		
			List<Issue> list = dao6.IssueID((page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = dao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("issues", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
			
		}else if(action.equalsIgnoreCase("SeveritySort")){
			forward = LIST_ISSUE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			List<Issue> list = dao6.SeveritySort((page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = dao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("issues", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
		}
		else if(action.equalsIgnoreCase("DueDateSort")){
			forward = LIST_ISSUE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			List<Issue> list = dao6.DueDateSort((page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = dao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("issues", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
		}
		else if(action.equalsIgnoreCase("UpdateDateSort")){
			forward = LIST_ISSUE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			List<Issue> list = dao6.UpdateDateSort((page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = dao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("issues", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
		}
		else if(action.equalsIgnoreCase("CreateDateSort")){
			forward = LIST_ISSUE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			List<Issue> list = dao6.CreateDateSort((page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = dao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("issues", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
			
		}
		else {
			forward = LIST_ISSUE;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			 List<Issue> list = dao.getAllIssue(projectID,(page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = dao.getNoOfRecords();
		    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("issues", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
			request.setAttribute("number",dao6.getNumberofIssue());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Issue issue = new Issue();

		HttpSession session = request.getSession();
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
		
		Date a = null;

		try {
			Date dueDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(request.getParameter("dueDate"));
			issue.setDueDate(dueDate);
			a=dueDate;

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			Timestamp updateDate = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(request.getParameter("updateDate"));
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
		if (issueID == null || issueID.isEmpty() || issueID == "0")
			dao.addIssue(issue);
		else {
			issue.setIssueID(Integer.parseInt(issueID));
			dao.updateIssue(issue);
		}
		
		

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+title+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+description+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+severity+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+priority+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+a+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+status+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+reporter+"</td></tr></table>";
        String user = "the.issue.tracking@gmail.com";
        String pass = "niksf203";
        SendMail.send(to,subject, message, user, pass);
		
		
		
		RequestDispatcher view = request.getRequestDispatcher(ISSUE_DETAIL);
		issue = dao.getIssueByLastInsert();
		request.setAttribute("issue", issue);
		request.setAttribute("labels", dao4.getAllLabelByProjectName(project));
		request.setAttribute("milestones", dao5.getMilestoneByIssueId(issue.getIssueID()));
		view.forward(request, response);

	}

}
