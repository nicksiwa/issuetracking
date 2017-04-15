package com.siwa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


@WebServlet("/MailApp")
public class MailApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MailApp() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        String to = request.getParameter("to");
	        String subject = request.getParameter("subject");
	        String message =  request.getParameter("message");
	        String user = request.getParameter("user");
	        String pass = request.getParameter("pass");
	        SendMail.send(to,subject, message, user, pass);
	        out.println("Mail send successfully");
	}

}
