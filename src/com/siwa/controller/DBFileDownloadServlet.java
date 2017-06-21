package com.siwa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
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

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatch;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;


@WebServlet("/downloadFileServlet")
public class DBFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Connection conn;
	 private static final int BUFFER_SIZE = 4096;   
	 
		private String dbURL = "jdbc:mysql://localhost/projectdb";
	    private String dbUser = "root";
	    private String dbPass = "password";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int testID = Integer.parseInt(request.getParameter("testID"));
		Connection conn = null;
		
		try{
			
			 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	         conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	 
			
			 String sql = "SELECT * FROM test WHERE id = ?";
	         PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, testID);
	 
	            ResultSet result = statement.executeQuery();
			
	            if(result.next()){
	            	String fileName = result.getString("file_name");
	                Blob blob = result.getBlob("file_data");
	                String fileType = result.getString("file_type");
	                
	                InputStream inputStream = blob.getBinaryStream();
	                int fileLength = inputStream.available();
	                System.out.println("fileLength = " + fileLength);
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

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
