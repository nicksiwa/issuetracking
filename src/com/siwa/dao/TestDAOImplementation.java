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
			String query = "insert into test (file) values (?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBlob(1, test.getFile());
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
			
		}
		
	}

	@Override
	public void updateTest(Test test) {
		try{
			String query = "update test set file=? where testID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBlob(1, test.getFile());
			ps.setInt(2, test.getTestID());
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Test> getAllTest() {
		List<Test> tests = new ArrayList<Test>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select testID,projectID,commentID from test,project,comment where testID=1 order by projectID,commentID");
			while(rs.next()){
				Test test = new Test();
				test.setTestID(rs.getInt("testID"));
				test.setTestProject(rs.getInt("projectID"));
				test.setTestComment(rs.getInt("commentID"));
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
			String query = "select testID,projectID,commentID from test,project,comment,person where personId=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, testID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				test.setTestID(rs.getInt("testID"));
				test.setTestProject(rs.getInt("projectID"));
				test.setTestComment(rs.getInt("commentID"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return test;
	}

}
