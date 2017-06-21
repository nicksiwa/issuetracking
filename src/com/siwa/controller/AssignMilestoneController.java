package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.AssignMilestoneDAO;
import com.siwa.dao.AssignMilestoneDAOImplementation;
import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.dao.FileDAO;
import com.siwa.dao.FileDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.model.AssignMilestone;
import com.siwa.model.Issue;


@WebServlet("/AssignMilestoneController")
public class AssignMilestoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DETAIL = "/issueDetail.jsp";
    private AssignMilestoneDAO dao;
    private IssueDAO dao2;
    private LabelDAO dao3;
    private MilestoneDAO dao4;
    private CommentDAO dao5;
    private FileDAO dao7;

    public AssignMilestoneController() {
       dao = new AssignMilestoneDAOImplementation();
       dao2 = new IssueDAOImplementation();
       dao3 = new LabelDAOImplementation();
       dao4 = new MilestoneDAOImplementation();
       dao5 = new CommentDAOImplementation();
       dao7 = new FileDAOImplementation();
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
		AssignMilestone assignMilestone = new AssignMilestone();
		
		String milestoneName = request.getParameter("milestoneName");
		milestoneName = new String(milestoneName.getBytes("ISO8859-1"), "UTF-8");
		assignMilestone.setMilestoneName(milestoneName);
		
		int issueID = Integer.parseInt(request.getParameter("issueID"));
		assignMilestone.setIssueID(issueID);
		
		String assignMilestoneID = request.getParameter("assignMilestoneID");
		if(assignMilestoneID == null || assignMilestoneID.isEmpty())
			dao.addAssignMilestone(assignMilestone);
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
		request.setAttribute("files", dao7.getAllFileByIssueId(issueID));
		view.forward(request, response);
	}

}
