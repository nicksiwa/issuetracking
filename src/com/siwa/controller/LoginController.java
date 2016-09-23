package com.siwa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.LoginDAO;
import com.siwa.dao.LoginDAOImplementation;
import com.siwa.model.Login;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO dao;
   
    public LoginController() {
       dao = new LoginDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login login = new Login();
		
		String username = request.getParameter("username");
		login.setUsername(username);
		
		String password = request.getParameter("password");
		login.setPassword(password);
		
		String userValidate = dao.authenticateUser(login);
		
		if(userValidate.equals("SUCCESS")){
			request.setAttribute("username", username);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
