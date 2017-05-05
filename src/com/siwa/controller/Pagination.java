package com.siwa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.PaginationDAO;
import com.siwa.dao.PersonDAO;
import com.siwa.dao.PersonDAOImplementation;
import com.siwa.model.Issue;
import com.siwa.model.Person;

@WebServlet("/Pagination")
public class Pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonDAO dao2;
    private IssueDAO dao;
    

    public Pagination() {
    	   super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
        int recordsPerPage = 10;
        
        if(request.getParameter("page") != null){
        	page = Integer.parseInt(request.getParameter("page"));
        }
        PaginationDAO dao = new PaginationDAO();
        List<Issue> list = dao.getAllIssueByPagination((page-1)*recordsPerPage,recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("issues", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("listIssue.jsp");
        view.forward(request, response);

	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	
}
