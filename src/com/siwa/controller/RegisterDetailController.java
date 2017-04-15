package com.siwa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
import com.siwa.dao.RegisterDAO;
import com.siwa.dao.RegisterDAOImplementation;
import com.siwa.model.Register;


@WebServlet("/RegisterDetailController")
public class RegisterDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RegisterDAO dao;
	 private IndexDAO daos;
	 private CommentDAO dao2;
	 public static final String INDEX = "/index.jsp";
       
   
    public RegisterDetailController() {
    	 dao = new RegisterDAOImplementation();
         daos = new IndexDAOImplementation();
         dao2 = new CommentDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register register = new Register();
		
		String firstname = (request.getParameter("firstname"));
		firstname = new String(firstname.getBytes("ISO8859-1"), "UTF-8");
		register.setFirstName(firstname);
		
		String lastname = (request.getParameter("lastname"));
		lastname = new String(lastname.getBytes("ISO8859-1"), "UTF-8");
		register.setLastName(lastname);
		
		try {
			Date birthdate = new SimpleDateFormat("yyyy-MM-dd",Locale.US).parse(request.getParameter("birthdate"));
			register.setBirthDate(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String gender = (request.getParameter("gender"));
		gender = new String(gender.getBytes("ISO8859-1"), "UTF-8");
		register.setGender(gender);
		
		String address = (request.getParameter("address"));
		address = new String(address.getBytes("ISO8859-1"), "UTF-8");
		register.setAddress(address);
		
		String tel = (request.getParameter("tel"));
		tel = new String(tel.getBytes("ISO8859-1"), "UTF-8");
		register.setTel(tel);
		
		String position = (request.getParameter("position"));
		position = new String(position.getBytes("ISO8859-1"), "UTF-8");
		register.setPosition(position);
		
		String userID = request.getParameter("userID");
		register.setUserID(Integer.parseInt(userID));
		
		String github = (request.getParameter("github"));
		github = new String(github.getBytes("ISO8859-1"), "UTF-8");
		register.setGithub(github);
		
		String email_id = (request.getParameter("email_id"));
		email_id = new String(email_id.getBytes("ISO8859-1"), "UTF-8");
		register.setEmail_id(email_id);
		
		dao.registerPerson(register);
		HttpSession session  = request.getSession();
		
		
		session.setAttribute("username", firstname+" "+lastname);
		
		request.setAttribute("indexs", daos.getAllIndex(firstname+" "+lastname));
		request.setAttribute("reports", daos.getReportByMe(firstname+" "+lastname));
		request.setAttribute("resolves", daos.getResolveIssue());
		request.setAttribute("recents", daos.getRecentlyModified());
		request.setAttribute("projects", daos.getProjectByUser(firstname+" "+lastname));
		request.setAttribute("publics", daos.getPublicProject());
		request.setAttribute("feedback", dao2.getFeedbackByUser(firstname+" "+lastname));
		request.setAttribute("unassign", daos.getUnassignIssue());
		
		RequestDispatcher view = request.getRequestDispatcher(INDEX);
		view.forward(request, response);
	}

}
