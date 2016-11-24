package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.RegisterDAO;
import com.siwa.dao.RegisterDAOImplementation;
import com.siwa.model.Register;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterDAO dao;
    public static final String REGISTER = "/register.jsp";
  
    public RegisterController() {
        dao = new RegisterDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		 if(action.equalsIgnoreCase("signup")){
			forward = REGISTER;
			
		}
		
		 RequestDispatcher view = request.getRequestDispatcher(forward);
		 view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Register register = new Register();
		
		String username = (request.getParameter("username"));
		username = new String(username.getBytes("ISO8859-1"), "UTF-8");
		register.setUsername(username);
		

		
		
		
	}

}
