package com.siwa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siwa.util.DBUtil;


@WebServlet("/downloadFileServlet")
public class DBFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Connection conn;
	 private static final int BUFFER_SIZE = 4096;   
	 
    public DBFileDownloadServlet() {
    	conn = DBUtil.getConnection();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int testID = Integer.parseInt(request.getParameter("testID"));
		
		try{
			
			 String sql = "SELECT * FROM test WHERE id = ?";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, testID);
	 
	            ResultSet result = statement.executeQuery();
			
	            if(result.next()){
	            	String fileName = result.getString("file_name");
	                Blob blob = result.getBlob("file_data");
	                InputStream inputStream = blob.getBinaryStream();
	                int fileLength = inputStream.available();

	                ServletContext context = getServletContext();
	                
	                String mimeType = context.getMimeType(fileName);
	                if (mimeType == null) {        
	                    mimeType = "application/octet-stream";
	                }   
	                
	                
	                response.setContentType(mimeType);
	                response.setContentLength(fileLength);
	                String headerKey = "Content-Disposition";
	                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
	                response.setHeader(headerKey, headerValue);
	                
	                
	                OutputStream outStream = response.getOutputStream();
	                 
	                byte[] buffer = new byte[BUFFER_SIZE];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outStream.write(buffer, 0, bytesRead);
	                }
	                 
	                inputStream.close();
	                outStream.close();             
	            	
	            }else{
	            	 response.getWriter().print("File not found for the id: " + testID);  
	            }
	            
		}catch(SQLException ex){
		    ex.printStackTrace();
            response.getWriter().print("SQL Error: " + ex.getMessage());
		}catch(IOException ex){
			 ex.printStackTrace();
	         response.getWriter().print("IO Error: " + ex.getMessage());
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
