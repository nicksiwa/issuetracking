package com.siwa.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.model.Comment;
import com.siwa.model.Issue;


@WebServlet("/CommentIssue")
public class CommentIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO dao;
	private IssueDAO dao2;
	private LabelDAO dao4;
	private MilestoneDAO dao5;
	
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";


    public CommentIssue() {
		dao = new CommentDAOImplementation();
		dao2 = new IssueDAOImplementation();
		dao4 = new LabelDAOImplementation();
		dao5 = new MilestoneDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment comment = new Comment();
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		String commentDetail = (request.getParameter("commentDetail"));
		commentDetail = new String(commentDetail.getBytes("ISO8859-1"), "UTF-8");
		comment.setCommentDetail(commentDetail);
		
		String userComment = username;
		userComment = new String(userComment.getBytes("ISO8859-1"), "UTF-8");
		comment.setUserComment(userComment);
		
		try {
			Timestamp commentTime = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("commentTime"));
			comment.setCommentTime(commentTime);
		} catch (ParseException e) {
			
		}
		
		int issueID = Integer.parseInt(request.getParameter("issueID"));
		comment.setIssueID(issueID);
		
		String commentID = request.getParameter("commentID");
		
		if (commentID == null || commentID.isEmpty())
			dao.addComment(comment);
		else {
	
		}
		
		Issue issue = new Issue();
		RequestDispatcher view = request.getRequestDispatcher(ISSUE_DETAIL);
		
		issue = dao2.getAssignById(issueID);
		request.setAttribute("issue", issue);			
		request.setAttribute("labels", dao4.getAllLabelByIssueID(issueID));
		request.setAttribute("labelAssigns", dao4.getAssignLabel(issueID));
		request.setAttribute("milestones", dao5.getMilestoneByIssueId(issueID));
		request.setAttribute("milestoneAssigns", dao5.getAssignMilestone(issueID));
		request.setAttribute("comments", dao2.getCommentByIssue(issueID));
		view.forward(request, response);
	}

}
