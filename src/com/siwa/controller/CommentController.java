package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.model.Comment;



@WebServlet("/CommentController")
public class CommentController extends HttpServlet {

       
	private CommentDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_COMMENT = "/listComment.jsp";
	public static final String INSERT_OR_EDIT = "/comment.jsp";

  
    public CommentController() {
    	dao = new CommentDAOImplementation();
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
		} else {
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
		
		String description = (request.getParameter("description"));
		description = new String(description.getBytes("ISO8859-1"), "UTF-8");
		comment.setDescription(description);
		
		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		comment.setStatus(status);
		
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
		RequestDispatcher view = request.getRequestDispatcher(LIST_COMMENT);
		request.setAttribute("comments", dao.getAllComment());
		view.forward(request, response);
		
	}

}
