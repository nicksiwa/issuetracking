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
import com.siwa.dao.LoginDAO;
import com.siwa.dao.LoginDAOImplementation;
import com.siwa.model.Login;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO dao;
    private IndexDAO daos;
    public static final String LOGIN = "/login.jsp";
   
    public LoginController() {
       dao = new LoginDAOImplementation();
       daos = new IndexDAOImplementation();
      
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action==null)
			forward = LOGIN;
		else if(action.equalsIgnoreCase("logout")){
			HttpSession session = request.getSession();
			session.removeAttribute("username");
			forward = LOGIN;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login login = new Login();
		
		String username = request.getParameter("username");
		login.setUsername(username);
		
		String password = request.getParameter("password");
		login.setPassword(password);
		
		String userValidate = dao.authenticateUser(login);
		
		if(userValidate.equals("SUCCESS")){
			
			HttpSession session  = request.getSession();
			session.setAttribute("username", username);
			
			request.setAttribute("username", username);
			request.setAttribute("indexs", daos.getAllIndex(username));
			request.setAttribute("reports", daos.getReportByMe(username));
			request.setAttribute("resolves", daos.getResolveIssue());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
