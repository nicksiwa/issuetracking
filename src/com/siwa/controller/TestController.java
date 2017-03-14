package com.siwa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.TaskDAO;
import com.siwa.dao.TaskDAOImplementation;
import com.siwa.dao.TestDAO;
import com.siwa.dao.TestDAOImplementation;
import com.siwa.model.Assign;
import com.siwa.model.Issue;
import com.siwa.model.Test;

@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private TaskDAO dao;
	private IssueDAO dao2;
	private TestDAO dao3;

	private static final long serialVersionUID = 1L;
	public static final String LIST_TEST = "/listTest.jsp";
	public static final String INSERT_OR_EDIT = "/test.jsp";
	public static final String STATUS = "/testStatus.jsp";
	public static final String INDEX = "/index.jsp";
	public static final String LIST_ISSUE = "/listIssue.jsp";
 

    public TestController() {
    	dao = new TaskDAOImplementation();
    	dao2 = new IssueDAOImplementation();
    	dao3 = new TestDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<String> list = new ArrayList<>();
	    list.add("item1");
	    list.add("item2");
	    list.add("item3");
	

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter();
	    
	    
		String forward = "";
		String action = request.getParameter("action");
		

		if (action.equalsIgnoreCase("test")) {
			forward = INSERT_OR_EDIT;
			request.setAttribute("dates", dao3.getDueDate());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

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
		request.setAttribute("issues", dao2.getReport(severity, status, firstDate+" 00:00:00.00", secondDate+" 23:59:59.999"));
		view.forward(request, response);
	}
	}


