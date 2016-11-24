package com.siwa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.siwa.dao.TestDAO;
import com.siwa.dao.TestDAOImplementation;
import com.siwa.model.Assign;
import com.siwa.model.Issue;
import com.siwa.model.Test;

@WebServlet("/TestController")
public class TestController extends HttpServlet {

	
    
	private TestDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_TEST = "/listTest.jsp";
	public static final String INSERT_OR_EDIT = "/test.jsp";
	public static final String STATUS = "/testStatus.jsp";
	public static final String INDEX = "/index.jsp";
 

    public TestController() {
       dao = new TestDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session  = request.getSession();
		
		
		if (action.equalsIgnoreCase("delete")) {
			forward = INSERT_OR_EDIT;
			
		} else {
			forward = INSERT_OR_EDIT;
			
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String connectionURL = "jdbc:mysql://localhost/projectdb"; // students is my database name
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "password");
            String uname = request.getParameter("uname");
		
            PreparedStatement ps = connection.prepareStatement("select username from user where username=?");
            ps.setString(1,uname);
            
            
            ResultSet rs = ps.executeQuery();
             
            if (!rs.next()) {
            	String msg = uname+" is avaliable";
            	System.out.println(msg);
            	out.println(msg);
            	request.setAttribute("m", msg);	               
       
            }
            else{
            out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
            System.out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
            }
            out.println();



        } catch (Exception ex) {

            out.println("Error ->" + ex.getMessage());

        } finally {
            out.close();
        }
	}

	}


