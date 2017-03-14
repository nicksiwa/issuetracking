package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.siwa.model.Issue;
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
			String query = "insert into test (testName,testProject) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, test.getTestName());
			ps.setString(2, test.getTestProject());
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
			ps.setString(1, test.getTestName());
			ps.setString(2, test.getTestProject());
			ps.setInt(3, test.getTestID());
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Test> getAllTest() {
		List<Test> tests = new ArrayList<Test>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from test");
			while(rs.next()){
				Test test = new Test();
				test.setTestID(rs.getInt("testID"));
				test.setTestName(rs.getString("testName"));
				test.setTestProject(rs.getString("testProject"));
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
	public Test getTestById(String testName) {
		Test test = new Test();
		try{
			String query = "select * from test where testName=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, testName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				test.setTestID(rs.getInt("testID"));
				test.setTestName(rs.getString("testName"));
				test.setTestProject(rs.getString("testProject"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return test;
	}

	@Override
	public Test getTestByUser(int testID) {
		try{
			Test test = new Test();
			String sql = "select username,password from person";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Test getTestByStatus(String status) {
		
		return null;
	}

	@Override
	public List<Test> getPersonAndProject() {
		List<Test> testss = new ArrayList<Test>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select firstName,projectName from person,project");
			while(rs.next()){
				Test test = new Test();
				test.setTestName(rs.getString("firstName"));
				test.setTestProject(rs.getString("projectName"));
				testss.add(test);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return testss;
	}

	@Override
	public List<Issue> getDueDate() {
		List<Issue> dates = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select dueDate from issue");
			while(rs.next()){
				Issue issue = new Issue();
				
				
				
				SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy",Locale.US);
				String inputString1 = new SimpleDateFormat("dd MM yyyy",Locale.US).format(Calendar.getInstance().getTime());
				String inputString2 = new SimpleDateFormat("dd MM yyyy",Locale.US).format(rs.getDate("dueDate"));

				 Date date1;
				 Date date2 = null;
				 long diff = 0;
				 long result = 0;
				try {
				    date1 = myFormat.parse(inputString1);
				    date2 = myFormat.parse(inputString2);
				    diff = date1.getTime() - date2.getTime();
				    result = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				    System.out.println ("");
				    
					if (result <= 0) {
						System.out.println ("Until " + result);
					} else {
						System.out.println ("Pass due date by " + result);
					}

					
				} catch (ParseException e) {
				    e.printStackTrace();
				}

				issue.setDueDateChecker(result);
				dates.add(issue);
				
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dates;
	}
}
