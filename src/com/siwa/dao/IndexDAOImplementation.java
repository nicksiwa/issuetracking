package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Index;
import com.siwa.util.DBUtil;

public class IndexDAOImplementation implements IndexDAO {
	
	private Connection conn;

	public IndexDAOImplementation() {
		conn = DBUtil.getConnection();
	}



	@Override
	public List<Index> getAllIndex(String assign) {
		List<Index> indexs = new ArrayList<Index>();
		try{
			String query = "select * from issue where assign=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, assign);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setAssign(rs.getString("assign"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				indexs.add(index);
			}
			
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return indexs;
	}



	@Override
	public List<Index> getReportByMe(String report) {
		List<Index> reports = new ArrayList<Index>();
		try{
			String query = "select * from issue where reporter=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, report);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setReporter(rs.getString("reporter"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				reports.add(index);
			}
			
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reports;
	}



	@Override
	public List<Index> getResolveIssue() {
		List<Index> resolves = new ArrayList<Index>();
		try{
			String query = "select * from issue where status='Resolved'";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setReporter(rs.getString("reporter"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				resolves.add(index);
			}
			rs.close();
			statement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resolves;
	}



}
