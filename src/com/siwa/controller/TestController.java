package com.siwa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.siwa.dao.TestDAO;
import com.siwa.dao.TestDAOImplementation;
import com.siwa.model.Test;

@WebServlet("/TestController")
public class TestController extends HttpServlet {

	
    
	private TestDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_TEST = "/listTest.jsp";
	public static final String INSERT_OR_EDIT = "/test.jsp";
	public static final String STATUS = "/testStatus.jsp";

 

    public TestController() {
       dao = new TestDAOImplementation();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_TEST;
			int testID = Integer.parseInt(request.getParameter("testID"));
			dao.deleteTest(testID);
			request.setAttribute("tests", dao.getAllTest());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int testID = Integer.parseInt(request.getParameter("personId"));
			Test test = dao.getTestById(testID);
			request.setAttribute("test", test);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
			request.setAttribute("testss", dao.getPersonAndProject());
			
			
			
		} else if (action.equalsIgnoreCase("status")) {
			forward = STATUS;
			String status = request.getParameter("status");
			Test test = dao.getTestByStatus(status);
			request.setAttribute("test", test);
		} else {
			forward = LIST_TEST;
			request.setAttribute("tests", dao.getAllTest());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test test = new Test();
		
		String testName = (request.getParameter("testName"));
		testName = new String(testName.getBytes("ISO8859-1"), "UTF-8");
		test.setTestName(testName);
	
	
		String testProject = (request.getParameter("testProject"));
		testProject = new String(testProject.getBytes("ISO8859-1"), "UTF-8");
		test.setTestProject(testProject);
            
           
		
		
            String testID = request.getParameter("testID");
        	
    		if (testID == null || testID.isEmpty())
    			dao.addTest(test);
    		else {
    			test.setTestID(Integer.parseInt(testID));
    			dao.updateTest(test);
    		}
    		RequestDispatcher view = request.getRequestDispatcher(LIST_TEST);
    		request.setAttribute("tests", dao.getAllTest());
    		view.forward(request, response);
    		
        }

	}


