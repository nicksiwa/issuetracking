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

import com.siwa.dao.RegisterDAO;
import com.siwa.dao.RegisterDAOImplementation;
import com.siwa.model.Person;
import com.siwa.model.Register;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PROFILE = "/profile.jsp";
	private RegisterDAO dao;

    public ProfileController() {
    	dao = new RegisterDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		

		if (action.equalsIgnoreCase("profile")) {
			forward = PROFILE;
			
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
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
	}

}
