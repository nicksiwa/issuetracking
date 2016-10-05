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
	public static final String LIST_INDEX = "/listIndex";
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

		}else{
			forward = LIST_INDEX;
			String assignName = username;
			request.setAttribute("indexs", dao.getAllIndex(assignName));
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Index index = new Index();
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String assignName = username;
		assignName = new String(assignName.getBytes("ISO8859-1"), "UTF-8");
		index.setAssignName(assignName);
		
	
		
		String assignProject = (request.getParameter("assignProject"));
		assignProject = new String(assignProject.getBytes("ISO8859-1"), "UTF-8");
		index.setAssignProject(assignProject);
		
		String assignTitle = (request.getParameter("assignTitle"));
		assignTitle = new String(assignTitle.getBytes("ISO8859-1") ,"UTF-8");
		index.setAssignTitle(assignTitle);
		
	
		RequestDispatcher view = request.getRequestDispatcher(INDEX);
		request.setAttribute("indexs", dao.getAllIndex(assignName));
		view.forward(request, response);
		
	}

}
