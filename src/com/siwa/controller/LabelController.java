package com.siwa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.model.Label;


@WebServlet("/LabelController")
public class LabelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String LABEL = "/projectLabels.jsp"; 
    private LabelDAO dao;

    public LabelController() {
       dao = new LabelDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = LABEL;
			int labelID = Integer.parseInt(request.getParameter("labelID"));
			dao.deleteLabel(labelID);
			request.setAttribute("labels", dao.getAllLabel());
			
		}else if(action.equalsIgnoreCase("insert")){
			forward = LABEL;
			
		}else if(action.equalsIgnoreCase("label")){
			forward = LABEL;
			request.setAttribute("labels", dao.getAllLabel());
		}else{
			forward = LABEL;
			request.setAttribute("labels", dao.getAllLabel());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Label label = new Label();
		
		String labelName = (request.getParameter("labelName"));
		labelName = new String(labelName.getBytes("ISO8859-1"), "UTF-8");
		label.setLabelName(labelName);
		
		String labelType = (request.getParameter("labelType"));
		labelType = new String(labelType.getBytes("ISO8859-1"), "UTF-8");
		label.setLabelType(labelType);
		
		String labelID = request.getParameter("labelID");
		if(labelID == null || labelID.isEmpty()){
			dao.addLabel(label);
		}else{
			
		}
		RequestDispatcher view = request.getRequestDispatcher(LABEL);
		request.setAttribute("labels", dao.getAllLabel());
		view.forward(request, response);
	}

}
