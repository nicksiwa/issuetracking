package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.IndexDAO;
import com.siwa.dao.IndexDAOImplementation;
import com.siwa.model.Index;


@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String INDEX = "/index.jsp";
	public static final String LIST_INDEX = "/listIndex.jsp";
	private IndexDAO dao;
       
  
    public IndexController() {
        dao = new IndexDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(action.equalsIgnoreCase("name")){
			forward = INDEX;
			String testName = (String) session.getAttribute("username");
			Index index = dao.getIndexById(testName);
			request.setAttribute("index", index);
			
		}else{
			forward = INDEX;
			String assign = (String) session.getAttribute("username");
			request.setAttribute("indexs", dao.getAllIndex(assign));
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Index index = new Index();
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String project = (request.getParameter("project"));
		project = new String(project.getBytes("ISO8859-1"), "UTF-8");
		index.setProject(project);
		
	
		String assign = username;
		assign = new String(assign.getBytes("ISO8859-1"), "UTF-8");
		index.setAssign(assign);
		
		String title = (request.getParameter("title"));
		title = new String(title.getBytes("ISO8859-1"), "UTF-8");
		index.setTitle(title);
		
		String updateDate = (request.getParameter("updateDate"));
		updateDate = new String(updateDate.getBytes("ISO8859-1"), "UTF-8");
		index.setUpdateDate(updateDate);
		
		String issueID = request.getParameter("issueID");
		index.setIssueID(Integer.parseInt(issueID));
	
		RequestDispatcher view = request.getRequestDispatcher(LIST_INDEX);
		request.setAttribute("issues", dao.getAllIndex(assign));
		view.forward(request, response);
		
	}

}
