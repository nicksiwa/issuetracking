package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			ResultSet rs = stat.executeQuery("select CONCAT_WS (' ',firstName, lastName) as full_name,`user`.username, `user`.`password` from person join `user` on person.user_ID = `user`.userID");
			while(rs.next()){
				usernameDB = rs.getString("username");
				passwordDB = rs.getString("password");
				login.setFirstname(rs.getString("full_name"));
				if(username.equals(usernameDB) && password.equals(passwordDB)){
					 return "SUCCESS";
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "Invalid username or passward";
	}

	@Override
	public Login getFirstNameSession(String username) {
			Login login = new Login();
		try{
			String query = "select CONCAT_WS (' ',firstName, lastName) as full_name,`user`.username, `user`.`password` from person join `user` on person.user_ID = `user`.userID and `user`.username=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				login.setFirstname(rs.getString("full_name"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return login;
	}

}
