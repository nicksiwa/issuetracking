package com.siwa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.siwa.dao.FileDAO;
import com.siwa.dao.FileDAOImplementation;
import com.siwa.dao.IssueDAO;
import com.siwa.dao.IssueDAOImplementation;
import com.siwa.dao.LabelDAO;
import com.siwa.dao.LabelDAOImplementation;
import com.siwa.dao.MilestoneDAO;
import com.siwa.dao.MilestoneDAOImplementation;
import com.siwa.model.Issue;
import com.siwa.util.DBUtil;


@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DETAIL = "/issueDetail.jsp";
	
	  private IssueDAO dao2;
	    private LabelDAO dao3;
	    private MilestoneDAO dao4;
	    private FileDAO dao7;
	    
	    public UploadServlet(){
	    	dao2 = new IssueDAOImplementation();
	        dao3 = new LabelDAOImplementation();
	        dao4 = new MilestoneDAOImplementation();
	        dao7 = new FileDAOImplementation();
	    }
	
		private String dbURL = "jdbc:mysql://localhost/projectdb";
	    private String dbUser = "root";
	    private String dbPass = "password";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = null;
		int issueID = Integer.parseInt(request.getParameter("issueID"));


        Part filePart = request.getPart("file");
        if (filePart != null) {

            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
        }
        Connection conn = null;
        String filename = filePart.getName();
        String filetype = filePart.getContentType();
        String message = null;

        try {
        	 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        	 conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "INSERT INTO test (file_name,file_data,issueID,file_type) values (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, filename);
            statement.setInt(3, issueID);
            statement.setString(4, filetype);

            if (inputStream != null) {

                statement.setBlob(2, inputStream);
                
            }

            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File is uploaded successfully into the Database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        }finally {
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            RequestDispatcher view = request.getRequestDispatcher(DETAIL);
            Issue issue = new Issue();
            issue = dao2.getAssignById(issueID);
    		request.setAttribute("issue", issue);
    		request.setAttribute("labels", dao3.getAllLabelByIssueID(issueID));
    		request.setAttribute("labelAssigns", dao3.getAssignLabel(issueID));
    		request.setAttribute("milestones", dao4.getMilestoneByIssueId(issueID));
    		request.setAttribute("milestoneAssigns", dao4.getAssignMilestone(issueID));
    		request.setAttribute("comments", dao2.getCommentByIssue(issueID));
    		request.setAttribute("files", dao7.getAllFileByIssueId(issueID));
    		view.forward(request, response);
            
        }

    }

}
