package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Test;
import com.siwa.util.DBUtil;

public class TestDAOImplementation implements TestDAO {
	
	private Connection conn;

	public TestDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addTest(Test test) {
		try{
			String query = "insert into test (testTime)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, test.getTestTime());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTest(int testID) {
		try{
			String query = "delete from test where testID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, testID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTest(Test test) {
		try{
			String query = "update test set testTime=? where testID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, test.getTestTime());
			ps.setInt(2, test.getTestID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Test> getAllTests() {
		List<Test> tests = new ArrayList<Test>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from test");
			while(rs.next()){
				Test test = new Test();
				test.setTestID(rs.getInt("testID"));
				test.setTestTime(rs.getString("testTime"));
				tests.add(test);
			}
			rs.close();
			stat.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tests;
	}

	@Override
	public Test getTestById(int testID) {
		Test test = new Test();
		try{
			String query = "select * from test where testID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,testID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				test.setTestID(rs.getInt("testID"));
				test.setTestTime(rs.getString("testTime"));		
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return test;
	}

}
