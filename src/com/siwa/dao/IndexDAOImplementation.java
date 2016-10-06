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
	public Index getIndexById(String assign) {
		Index index = new Index();
		try{
			String query = "select * from issue where assign=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, assign);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setAssign(rs.getString("assign"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return index;
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
			System.out.println(indexs.size());
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return indexs;
	}


	
	

}
