package com.siwa.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Comment;
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

	public static final String LIST_ISSUE = "/listIssue.jsp";
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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		} else if (action.equalsIgnoreCase("test")) {
			forward = LIST_ISSUE;
		} else {
			forward = LIST_ISSUE;
			request.setAttribute("issues", dao.getAllIssue());
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
