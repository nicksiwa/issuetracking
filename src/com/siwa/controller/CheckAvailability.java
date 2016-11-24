package com.siwa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckAvailability extends HttpServlet {
	private static final long serialVersionUID = -734503860925086969L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            
            System.out.print(uname);
            
            ResultSet rs = ps.executeQuery();
             
            if (!rs.next()) {
                out.println("<font color=green><b>"+uname+"</b> is avaliable");
            }
            else{
            out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
            }
            out.println();



        } catch (Exception ex) {

            out.println("Error ->" + ex.getMessage());

        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
