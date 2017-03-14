package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.AssignLabelDAO;
import com.siwa.dao.AssignLabelDAOImplementation;
import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.model.AssignLabel;
import com.siwa.model.Issue;


@WebServlet("/AssignLabelController")
public class AssignLabelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DETAIL = "/issueDetail.jsp";
    private AssignLabelDAO dao;
    private IssueDAO dao2;
    private LabelDAO dao3;
    private MilestoneDAO dao4;
    private CommentDAO dao5;
  
    public AssignLabelController() {
       dao = new AssignLabelDAOImplementation();
       dao2 = new IssueDAOImplementation();
       dao3 = new LabelDAOImplementation();
       dao4 = new MilestoneDAOImplementation();
       dao5 = new CommentDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("delete")){
			forward = DETAIL;
		}else if(action.equalsIgnoreCase("insert")){
			forward = DETAIL;
		}else{
			forward = DETAIL;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AssignLabel assignlabel = new AssignLabel();
	
		String labelName = request.getParameter("labelName");
		labelName = new String(labelName.getBytes("ISO8859-1"), "UTF-8");
		assignlabel.setLabelName(labelName);
		
		
		int issueID = Integer.parseInt(request.getParameter("issueID"));
		assignlabel.setIssueID(issueID);
		
		String assignLabelID = request.getParameter("assignLabelID");
		if(assignLabelID == null || assignLabelID.isEmpty())
			dao.addAssignLabel(assignlabel);
		else{
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(DETAIL);
		Issue issue = new Issue();
		issue = dao2.getAssignById(issueID);
		request.setAttribute("issue", issue);
		request.setAttribute("labels", dao3.getAllLabelByIssueID(issueID));
		request.setAttribute("labelAssigns", dao3.getAssignLabel(issueID));
		request.setAttribute("milestones", dao4.getMilestoneByIssueId(issueID));
		request.setAttribute("milestoneAssigns", dao4.getAssignMilestone(issueID));
		request.setAttribute("comments", dao2.getCommentByIssue(issueID));
		view.forward(request, response);
	}

}
