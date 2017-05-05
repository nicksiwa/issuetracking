package com.siwa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.model.Issue;
import com.google.gson.Gson;


@WebServlet("/AjaxTestController")
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IssueDAO dao;

    public AjaxTestController() {
    	dao = new IssueDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<>();
	    list.add("ฟหดฟดฟดห");
	    list.add("ฟหดดหฟดฟดฟ");
	    list.add("ฟหกด");
	    String json = new Gson().toJson(list);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = (request.getParameter("email_id"));
	    String json = new Gson().toJson(dao.getEmailByUsername(username));
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
