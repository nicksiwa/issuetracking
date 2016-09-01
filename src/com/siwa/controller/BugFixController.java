package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.BugFixDAO;
import com.siwa.dao.BugFixDAOImplementation;
import com.siwa.model.BugFix;
import com.siwa.model.Person;



@WebServlet("/BugFixController")
public class BugFixController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BugFixDAO dao;
       public static final String lIST_BUG = "/listBug.jsp";
   	public static final String INSERT_OR_EDIT = "/bug.jsp";
  
    public BugFixController() {
      dao = new  BugFixDAOImplementation();
    }

    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			forward = lIST_BUG;
			int bugId = Integer.parseInt(request.getParameter("bugId"));
			dao.deleteBug(bugId);
			request.setAttribute("bugs", dao.getAllBugs());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int bugId = Integer.parseInt(request.getParameter("bugId"));
			BugFix bug = dao.getBugById(bugId);
			request.setAttribute("bug", bug);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else {
			forward = lIST_BUG;
			request.setAttribute("bugs", dao.getAllBugs());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		BugFix bug  = new BugFix();
		
		String title = (request.getParameter("title"));
		title = new String(title.getBytes("ISO8859-1"),"UTF-8");
		bug.setTitle(title);
		
		String detail = (request.getParameter("detail"));
		detail = new String(detail.getBytes("ISO8859-1"),"UTF-8");
		bug.setDetail(detail);
		
		String workPer = (request.getParameter("workPer"));
		workPer = new String(workPer.getBytes("ISO8859-1"),"UTF-8");
		bug.setWorkPer(workPer);
		
		String resPerson = (request.getParameter("resPerson"));
		resPerson = new String(resPerson.getBytes("ISO8859-1"),"UTF-8");
		bug.setResPerson(resPerson);
		
		String bugId = request.getParameter("bugId");
		
		if(bugId == null || bugId.isEmpty()){
			dao.addBug(bug);
		}else{
			bug.setBugId(Integer.parseInt(bugId));
			dao.updateBug(bug);
		}
		RequestDispatcher view = request.getRequestDispatcher(lIST_BUG);
		request.setAttribute("bugs", dao.getAllBugs());
		view.forward(request, response);
		
	}

}
