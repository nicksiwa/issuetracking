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

import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.dao.EditStatusDAO;
import com.siwa.dao.EditStatusDAOIM;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.model.Comment;
import com.siwa.model.Issue;



@WebServlet("/CommentController")
public class CommentController extends HttpServlet {

       
	private CommentDAO dao;
	private EditStatusDAO dao3;
	private IssueDAO dao2;
	private static final long serialVersionUID = 1L;
	public static final String LIST_COMMENT = "/listComment.jsp";
	public static final String INSERT_OR_EDIT = "/comment.jsp";
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";

  
    public CommentController() {
    	dao = new CommentDAOImplementation();
    	 dao3 = new EditStatusDAOIM();
         dao2 = new IssueDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

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
		} 
		else if(action.equalsIgnoreCase("detail")){
			
		}
		else {
			forward = LIST_COMMENT;
			request.setAttribute("comments", dao.getAllComment());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comment comment = new Comment();
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String commentDetail = (request.getParameter("commentDetail"));
		commentDetail = new String(commentDetail.getBytes("ISO8859-1"), "UTF-8");
		comment.setCommentDetail(commentDetail);
		
		String commentTime = (request.getParameter("commentTime"));
		commentTime = new String(commentTime.getBytes("ISO8859-1"), "UTF-8");
		comment.setCommentTime(commentTime);
		
		String userComment = username;
		userComment = new String(userComment.getBytes("ISO8859-1"), "UTF-8");
		comment.setUserComment(userComment);
		
		String commentID = request.getParameter("commentID");
	
		if (commentID == null || commentID.isEmpty())
			dao.addComment(comment);
		else {
			comment.setCommentID(Integer.parseInt(commentID));
			dao.updateComment(comment);
		}
		
		
		
		int issueID2 = Integer.parseInt(request.getParameter("issueID"));
		request.setAttribute("comments", dao2.getCommentByIssue(issueID2));
		
		RequestDispatcher view  = request.getRequestDispatcher(ISSUE_DETAIL);
		view.forward(request, response);
		
	}

}
