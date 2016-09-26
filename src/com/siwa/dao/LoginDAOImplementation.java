package com.siwa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.siwa.model.Login;
import com.siwa.util.DBUtil;

public class LoginDAOImplementation implements LoginDAO {

	private Connection conn;

	public LoginDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public String authenticateUser(Login login) {
		
		String username = login.getUsername();
		String password = login.getPassword();
		
		String usernameDB = "";
		String passwordDB = "";
		
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select username,password from user");
			while(rs.next()){
				usernameDB = rs.getString("username");
				passwordDB = rs.getString("password");
				if(username.equals(usernameDB) && password.equals(passwordDB)){
					 return "SUCCESS";
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return "Invalid User";
	}

}
