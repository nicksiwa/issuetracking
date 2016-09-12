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
			int testID = Integer.parseInt(request.getParameter("testID"));
			Test test = dao.getTestById(testID);
			request.setAttribute("test", test);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else {
			forward = LIST_TEST;
			request.setAttribute("tests", dao.getAllTest());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test test = new Test();
		InputStream inputStream = null;
		 
        Part filePart = request.getPart("file");
        if (filePart != null) {
           
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
            
            
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

}
