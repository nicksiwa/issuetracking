package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.CommentDAO;
import com.siwa.dao.CommentDAOImplementation;
import com.siwa.dao.IndexDAO;
import com.siwa.dao.IndexDAOImplementation;
import com.siwa.dao.LoginDAO;
import com.siwa.dao.LoginDAOImplementation;
import com.siwa.dao.PersonDAO;
import com.siwa.dao.PersonDAOImplementation;
import com.siwa.model.Login;
import com.siwa.model.Person;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO dao;
    private IndexDAO daos;
    private CommentDAO dao2;
    private PersonDAO dao3;
    public static final String LOGIN = "/login.jsp";
    public static final String REGISTER = "/register.jsp";
   
    public LoginController() {
       dao = new LoginDAOImplementation();
       daos = new IndexDAOImplementation();
       dao2 = new CommentDAOImplementation();
       dao3 = new PersonDAOImplementation();
      
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action==null)
			forward = LOGIN;
			
		else if(action.equalsIgnoreCase("signup")){
			forward = REGISTER;
		}
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
		
		String firstname = request.getParameter("firstName");
		login.setFirstname(firstname);
		
		
		String userValidate = dao.authenticateUser(login);
		if(userValidate.equals("SUCCESS")){
			
			login = dao.getFirstNameSession(username);
			request.setAttribute("login", login);
			
			HttpSession session  = request.getSession();
			session.setAttribute("username", login.getFirstname());
			
			request.setAttribute("username", username);
			request.setAttribute("indexs", daos.getAllIndex(login.getFirstname()));
			request.setAttribute("reports", daos.getReportByMe(login.getFirstname()));
			request.setAttribute("resolves", daos.getResolveIssue());
			request.setAttribute("recents", daos.getRecentlyModified());
			request.setAttribute("projects", daos.getProjectByUser(login.getFirstname()));
			request.setAttribute("publics", daos.getPublicProject());
			request.setAttribute("feedback", dao2.getFeedbackByUser(login.getFirstname()));
			request.setAttribute("unassign", daos.getUnassignIssue());
			Person person = dao3.getPersonByUsername(username);
			request.setAttribute("person", person);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
