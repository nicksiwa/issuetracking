package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.siwa.model.Register;
import com.siwa.util.DBUtil;

public class RegisterDAOImplementation implements RegisterDAO {
	
	private Connection conn;
	
	public RegisterDAOImplementation(){
		conn = DBUtil.getConnection();
	}

	@Override
	public void registerUser(Register register) {

		try{
			String query = "insert into user (username,password) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, register.getUsername());
			ps.setString(2, register.getPassword());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void registerPerson(Register register) {
		try{
			String query = "insert into person (firstName, lastName, birthDate, gender, address, tel, position, user_ID) values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, register.getFirstName());
			ps.setString(2, register.getLastName());
			ps.setDate(3, new java.sql.Date (register.getBirthDate().getTime()));
			ps.setString(4, register.getGender());
			ps.setString(5, register.getAddress());
			ps.setString(6, register.getTel());
			ps.setString(7, register.getPosition());
			ps.setInt(8, register.getUserID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
