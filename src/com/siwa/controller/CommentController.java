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

import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.dao.EditStatusDAO;
import com.siwa.dao.EditStatusDAOIM;
import com.siwa.dao.IndexDAO;
import com.siwa.dao.IndexDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.dao.PersonDAO;
import com.siwa.dao.PersonDAOImplementation;
import com.siwa.model.Comment;
import com.siwa.model.Issue;
import com.siwa.model.Person;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {

	private CommentDAO dao;
	private EditStatusDAO dao3;
	private IssueDAO dao2;
	private IndexDAO dao4;
	private LabelDAO dao5;
	private MilestoneDAO dao6;
	private PersonDAO dao7;
	
	private static final long serialVersionUID = 1L;
	public static final String LIST_COMMENT = "/listComment.jsp";
	public static final String INSERT_OR_EDIT = "/comment.jsp";
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";
	public static final String ASSIGN = "/statusAssign.jsp";
	public static final String FEEDBACK = "/statusFeedback.jsp";
	public static final String CONFIRMED = "/statusConfirmed.jsp";
	public static final String RESOLVED = "/statusResolved.jsp";
	public static final String CLOSED = "/issueClosed.jsp";

	public CommentController() {
		dao = new CommentDAOImplementation();
		dao3 = new EditStatusDAOIM();
		dao2 = new IssueDAOImplementation();
		dao4 = new IndexDAOImplementation();
		dao5 = new LabelDAOImplementation();
		dao6 = new MilestoneDAOImplementation();
		dao7 = new PersonDAOImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
	
		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_COMMENT;
			int commentID = Integer.parseInt(request.getParameter("commentID"));
			dao.deleteComment(commentID);
			request.setAttribute("comments", dao.getAllComment());   
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int commentID = Integer.parseInt(request.getParameter("commentID"));
			Comment comment = dao.getCommentById(commentID);
			request.setAttribute("comment", comment);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else if (action.equalsIgnoreCase("assign")) {
			forward = ASSIGN;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = new Issue();
			
			issue = dao2.getAssignById(issueID);
			String assignusername = issue.getAssign();
			Issue email = dao2.getEmailByUsername(assignusername);		
			String to = email.getEmail_id();
		    String subject = "Issue assign to you has been change status to assigned";
		    String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+issue.getTitle()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+issue.getDescription()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+issue.getSeverity()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+issue.getPriority()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+issue.getDueDate()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+issue.getStatus()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+issue.getReporter()+"</td></tr></table>";
		    String user = "the.issue.tracking@gmail.com";
		    String pass = "niksf203";
		    SendMail.send(to,subject, message, user, pass);
			
			issue.setIssueID(issueID);
			dao2.setStatusAssign(issue);
			issue = dao.getIssueById(issueID);
			request.setAttribute("issue", issue);

		} else if (action.equalsIgnoreCase("feedback")) {
			forward = FEEDBACK;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = new Issue();
			
			issue = dao2.getAssignById(issueID);
			String assignusername = issue.getAssign();
			Issue email = dao2.getEmailByUsername(assignusername);		
			String to = email.getEmail_id();
		    String subject = "Issue assign to you has been change status to feedback";
		    String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+issue.getTitle()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+issue.getDescription()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+issue.getSeverity()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+issue.getPriority()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+issue.getDueDate()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+issue.getStatus()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+issue.getReporter()+"</td></tr></table>";
		    String user = "the.issue.tracking@gmail.com";
		    String pass = "niksf203";
		    SendMail.send(to,subject, message, user, pass);
			
			issue.setIssueID(issueID);
			dao2.setStatusFeedback(issue);
			issue = dao.getIssueById(issueID);
			request.setAttribute("issue", issue);
			request.setAttribute("persons", dao.getPersonById(issueID));
			
		} else if (action.equalsIgnoreCase("confirmed")) {
			forward = CONFIRMED;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = new Issue();
			
			issue = dao2.getAssignById(issueID);
			String assignusername = issue.getAssign();
			Issue email = dao2.getEmailByUsername(assignusername);		
			String to = email.getEmail_id();
		    String subject = "Issue assign to you has been change status to confirmed";
		    String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+issue.getTitle()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+issue.getDescription()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+issue.getSeverity()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+issue.getPriority()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+issue.getDueDate()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+issue.getStatus()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+issue.getReporter()+"</td></tr></table>";
		    String user = "the.issue.tracking@gmail.com";
		    String pass = "niksf203";
		    SendMail.send(to,subject, message, user, pass);
			
			issue.setIssueID(issueID);
			dao2.setStatusConfirmed(issue);
			issue = dao.getIssueById(issueID);
			request.setAttribute("issue", issue);
		} else if (action.equalsIgnoreCase("resolved")) {
			forward = RESOLVED;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = new Issue();
			
			issue = dao2.getAssignById(issueID);
			String assignusername = issue.getAssign();
			Issue email = dao2.getEmailByUsername(assignusername);		
			String to = email.getEmail_id();
		    String subject = "Issue assign to you has been change status to resolved";
		    String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+issue.getTitle()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+issue.getDescription()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+issue.getSeverity()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+issue.getPriority()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+issue.getDueDate()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+issue.getStatus()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+issue.getReporter()+"</td></tr></table>";
		    String user = "the.issue.tracking@gmail.com";
		    String pass = "niksf203";
		    SendMail.send(to,subject, message, user, pass);
			
			issue.setIssueID(issueID);
			dao2.setStatusResolved(issue);
			issue = dao.getIssueById(issueID);
			request.setAttribute("issue", issue);
		} 
		else if(action.equalsIgnoreCase("closed")){
			forward = CLOSED;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = new Issue();
			issue.setIssueID(issueID);
			dao2.setStatusClose(issue);
			
			Comment comment = new Comment();
			comment.setUserComment(username);
			comment.setIssueID(issueID);
			dao.addCommentClose(comment);
		
			request.setAttribute("issues", dao2.getAllIssueClosed());
			request.setAttribute("label", dao4.getLabelByIssueId(username));
			
			
			
		} 
		else if(action.equalsIgnoreCase("closedissue")){
			forward = CLOSED;
			request.setAttribute("issues", dao2.getAllIssueClosed());
			request.setAttribute("label", dao4.getLabelByIssueId(username));
			Person person = dao7.getGitHubByUsername(username);
			request.setAttribute("person", person);
			
		}
		else if(action.equalsIgnoreCase("reopenissue")){
			forward = ISSUE_DETAIL;
			int issueID = Integer.parseInt(request.getParameter("issueID"));
			Issue issue = new Issue();
			issue.setIssueID(issueID);
			dao2.setStatusReOpen(issue);
			issue = dao2.getAssignById(issueID);
			
			Comment comment = new Comment();
			comment.setUserComment(username);
			comment.setIssueID(issueID);
			dao.addCommentRepone(comment);
			
			request.setAttribute("issue", issue);
			request.setAttribute("labels", dao5.getAllLabelByIssueID(issueID));
			request.setAttribute("labelAssigns", dao5.getAssignLabel(issueID));
			request.setAttribute("milestones", dao6.getMilestoneByIssueId(issueID));
			request.setAttribute("milestoneAssigns", dao6.getAssignMilestone(issueID));
			request.setAttribute("comments", dao2.getCommentByIssue(issueID));
			
			String assignusername = issue.getAssign();
			Issue email = dao2.getEmailByUsername(assignusername);	
			String to = email.getEmail_id();
		    String subject = "Issue assign to you has been re-opened";
		    String message =  "<table width='600px' align='center' cellpadding='10' cellspacing='5'><tr align='left'><td bgcolor='#41e097' align='right'><b>Title : </b></td><td bgcolor='#e8e8e8'>"+issue.getTitle()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Description : </b></td><td bgcolor='#e8e8e8'>"+issue.getDescription()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Severity : </b></td><td bgcolor='#e8e8e8'>"+issue.getSeverity()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Priority : </b></td><td bgcolor='#e8e8e8'>"+issue.getPriority()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>DueDate : </b></td><td bgcolor='#e8e8e8'>"+issue.getDueDate()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Status : </b></td><td bgcolor='#e8e8e8'>"+issue.getStatus()+"</td></tr>"+"<tr align='left'><td bgcolor='#41e097' align='right'><b>Reporter : </b></td><td bgcolor='#e8e8e8'>"+issue.getReporter()+"</td></tr></table>";
		    String user = "the.issue.tracking@gmail.com";
		    String pass = "niksf203";
		    SendMail.send(to,subject, message, user, pass);
			
		}
		else {
			forward = LIST_COMMENT;
			request.setAttribute("comments", dao.getAllComment());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		Comment comment = new Comment();

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		String commentDetail = (request.getParameter("commentDetail"));
		commentDetail = new String(commentDetail.getBytes("ISO8859-1"), "UTF-8");
		comment.setCommentDetail(commentDetail);

		
		try {
			Timestamp commentTime = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("commentTime"));
			comment.setCommentTime(commentTime);
		} catch (ParseException e) {
			
		}
		
		
		

		String userComment = username;
		userComment = new String(userComment.getBytes("ISO8859-1"), "UTF-8");
		comment.setUserComment(userComment);

		int issueID = Integer.parseInt(request.getParameter("issueID"));
		comment.setIssueID(issueID);

		String commentID = request.getParameter("commentID");
		
		Issue issue = new Issue();
		
		String commentAssign = (request.getParameter("commentAssign"));
		commentAssign = new String(commentAssign.getBytes("ISO8859-1"), "UTF-8");
		comment.setCommentAssign(commentAssign);
		
		
		String status = request.getParameter("status");

		

		if (status.equals("Assign")){
			String commentStatus = "Assign";
			commentStatus = new String(commentStatus.getBytes("ISO8859-1"), "UTF-8");
			comment.setCommentStatus(commentStatus);
			dao.addComment(comment);
			issue.setIssueID(issueID);
			dao2.setStatusAssign(issue);
		}else if (status.equals("Feedback")){
			String commentStatus = "Feedback";
			commentStatus = new String(commentStatus.getBytes("ISO8859-1"), "UTF-8");
			comment.setCommentStatus(commentStatus);
			dao.addComment(comment);
			issue.setIssueID(issueID);
			dao2.setStatusFeedback(issue);
		}else if(status.equals("Confirmed")){
			String commentStatus = "Confirmed";
			commentStatus = new String(commentStatus.getBytes("ISO8859-1"), "UTF-8");
			comment.setCommentStatus(commentStatus);
			dao.addComment(comment);
			issue.setIssueID(issueID);
			dao2.setStatusConfirmed(issue);
		}else if(status.equals("Resolved")){
			String commentStatus = "Resolved";
			commentStatus = new String(commentStatus.getBytes("ISO8859-1"), "UTF-8");
			comment.setCommentStatus(commentStatus);
			dao.addComment(comment);
			issue.setIssueID(issueID);
			dao2.setStatusResolved(issue);
		}
		else {
			comment.setCommentID(Integer.parseInt(commentID));
			dao.updateComment(comment);
		}

		
		
		issueID = Integer.parseInt(request.getParameter("issueID"));
		issue = dao2.getAssignById(issueID);
		
		request.setAttribute("issue", issue);
		request.setAttribute("comments", dao2.getCommentByIssue(issueID));
		RequestDispatcher view = request.getRequestDispatcher(ISSUE_DETAIL);
		view.forward(request, response);

	}

}
