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
import com.siwa.dao.ProjectDAO;
import com.siwa.dao.ProjectDAOImplementation;
import com.siwa.model.Label;
import com.siwa.model.Project;


@WebServlet("/LabelController")
public class LabelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String LABEL = "/projectLabels.jsp"; 
    private LabelDAO dao;
    private ProjectDAO dao2;

    public LabelController() {
       dao = new LabelDAOImplementation();
       dao2 = new ProjectDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			forward = LABEL;
			int labelID = Integer.parseInt(request.getParameter("labelID"));
			dao.deleteLabel(labelID);
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("labels", dao.getAllLabelByProjectId(projectID));
		}else if(action.equalsIgnoreCase("insert")){
			forward = LABEL;
			
		}else if(action.equalsIgnoreCase("label")){
			forward = LABEL;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			Project project = dao2.getProjectById(projectID);
			request.setAttribute("project", project);
			request.setAttribute("labels", dao.getAllLabelByProjectId(projectID));
		}else{
			forward = LABEL;
			int projectID = Integer.parseInt(request.getParameter("projectID"));
			request.setAttribute("labels", dao.getAllLabelByProjectId(projectID));
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
		
		int labelProject = Integer.parseInt((request.getParameter("projectID")));
		label.setLabelProject(labelProject);
		
		String labelID = request.getParameter("labelID");
		if(labelID == null || labelID.isEmpty()){
			dao.addLabel(label);
		}else{
			
		}
		RequestDispatcher view = request.getRequestDispatcher(LABEL);
		int projectID = Integer.parseInt(request.getParameter("projectID"));
		Project project = dao2.getProjectById(projectID);
		request.setAttribute("project", project);
		request.setAttribute("labels", dao.getAllLabelByProjectId(projectID));
		view.forward(request, response);
	}

}
