package com.siwa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.PersonDAO;
import com.siwa.dao.PersonDAOImplementation;
import com.siwa.model.Person;

@WebServlet("/Pagination")
public class Pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonDAO dao;
    private HttpSession session;
    public final int perPagesArticles = 2;

    public Pagination() {

    	dao = new PersonDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person person = new Person();
		String action = request.getParameter("action");
		session = request.getSession();
		if (action!=null&&action.equals("load")) {
			session = request.getSession();
			session.setAttribute("pageNumber", 1);
			dao.pagination(0, perPagesArticles);
			session.setAttribute("persons", person);
			session.setAttribute("startIndex", 0);
			session.setAttribute("btnNext", "Next");
			session.setAttribute("btnPrevious", "Previous Disabled");
			if (person!=null&&person.size() < perPagesArticles
					|| person.size() == 0) {
				session.setAttribute("btnNext", "");
				session.setAttribute("btnPrevious", "");
			}
			
		}
		
	}

}
