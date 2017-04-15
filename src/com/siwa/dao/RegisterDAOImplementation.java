package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			String query = "insert into person (firstName, lastName, birthDate, gender, address, tel, position, user_ID, github, email_id, email_password) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, register.getFirstName());
			ps.setString(2, register.getLastName());
			ps.setDate(3, new java.sql.Date (register.getBirthDate().getTime()));
			ps.setString(4, register.getGender());
			ps.setString(5, register.getAddress());
			ps.setString(6, register.getTel());
			ps.setString(7, register.getPosition());
			ps.setInt(8, register.getUserID());
			ps.setString(9, register.getGithub());
			ps.setString(10, register.getEmail_id());
			ps.setString(11, register.getEmail_password());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Register checkUser(String user) {
		Register register = new Register();
		try{
			String query = "select username from user where username=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				register.setUsername(rs.getString("username"));
			}
			
			   if (!rs.next()) {
	                System.out.println("<font color=green><b>"+user+"</b> is avaliable");
	               
	            }
	            else{
	            	System.out.println("<font color=red><b>"+user+"</b> is already in use</font>");
	            }
			   System.out.println();
			ps.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Register getId(int id) {
		Register re = new Register();
		try{
			String query = "select username from user where userID=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				re.setUsername(rs.getString("username"));
				
			}
			rs.close();
			preparedStatement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public String checkUsername(Register regis) {
		String username = regis.getUsername();
		String usernameDB ="";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select username from user");
			while(rs.next()){
				usernameDB = rs.getString("username");
				if(username.equals(usernameDB)){
					return usernameDB+" is not available";
					
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "Available";
		
	}

	@Override
	public Register getUserPrimaryKey(String username) {
		Register regis = new Register();
		try{
			String query = "select `user`.userID from user where `user`.username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				regis.setUserID(rs.getInt("userID"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return regis;
	}

	@Override
	public void updateProfile(Register register) {
		try{
			String query = "update person set firstName=?, lastName=?, birthDate=?, gender=?, address=?, tel=?, position=?, user_ID=?, github=? where personId=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, register.getFirstName());
			ps.setString(2, register.getLastName());
			ps.setDate(3, new java.sql.Date (register.getBirthDate().getTime()));
			ps.setString(4, register.getGender());
			ps.setString(5, register.getAddress());
			ps.setString(6, register.getTel());
			ps.setString(7, register.getPosition());
			ps.setInt(8, register.getUserID());
			ps.setString(9, register.getGithub());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Register getPersonById(String username) {
		Register register = new Register();
		try{
			String query = "select * from person where personId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("LastName"));
				register.setBirthDate(resultSet.getDate("birthDate"));
				register.setGender(resultSet.getString("gender"));
				register.setAddress(resultSet.getString("address"));
				register.setTel(resultSet.getString("tel"));
				register.setPosition(resultSet.getString("position"));
				register.setGithub(resultSet.getString("github"));

			}
			resultSet.close();
			preparedStatement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return register;
	}

}
