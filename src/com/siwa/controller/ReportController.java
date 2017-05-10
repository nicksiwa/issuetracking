package com.siwa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.dao.ReportDAO;
import com.siwa.dao.ReportDAOImplementation;
import com.siwa.model.Issue;
import com.siwa.model.Project;

@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IssueDAO dao;
	private ReportDAO dao2;
	private ProjectDAO dao3;
	public static final String ISSUE_DETAIL = "/issueDetail.jsp";
    public static final String LIST_ISSUE = "/listIssue.jsp";
    public static final String PROJECT_GRAPH = "/projectGraph.jsp";
	public ReportController() {

		dao = new IssueDAOImplementation();
		dao2 = new ReportDAOImplementation();
		dao3 = new ProjectDAOImplementation();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("severity")) {

			out.print(gson.toJson(dao2.getAllIssue()));
			out.flush();
			out.close();
		} else if (action.equalsIgnoreCase("status")) {
			out.print(gson.toJson(dao2.GrapStatus()));
			out.flush();
			out.close();
		}else{
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao3.getProjectById(projectID);
			request.setAttribute("project", project);
			forward = PROJECT_GRAPH;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Issue issue = new Issue();

		String severity = (request.getParameter("severity"));
		severity = new String(severity.getBytes("ISO8859-1"), "UTF-8");
		issue.setSeverity(severity);

		String status = (request.getParameter("status"));
		status = new String(status.getBytes("ISO8859-1"), "UTF-8");
		issue.setStatus(status);

		String priority = (request.getParameter("priority"));
		priority = new String(priority.getBytes("ISO8859-1"), "UTF-8");
		issue.setPriority(priority);

		String firstDate = (request.getParameter("firstDate"));
		firstDate = new String(firstDate.getBytes("ISO8859-1"), "UTF-8");
		issue.setAssign(firstDate);

		String secondDate = (request.getParameter("secondDate"));
		secondDate = new String(secondDate.getBytes("ISO8859-1"), "UTF-8");
		issue.setDescription(secondDate);

		RequestDispatcher view = request.getRequestDispatcher(LIST_ISSUE);
		int projectID = Integer.parseInt(request.getParameter("projectID"));
		Project project = dao3.getProjectById(projectID);
		request.setAttribute("project", project);
		request.setAttribute("issues",dao.getReport(severity, status, firstDate + " 00:00:00.00", secondDate + " 23:59:59.999", priority));
		view.forward(request, response);
	}

}
