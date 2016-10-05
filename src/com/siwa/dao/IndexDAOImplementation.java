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
	public List<Index> getAllIndex(String assignName) {
		List<Index> indexs = new ArrayList<Index>();
		try{
			String query = "select project,assign,title from issue where assign=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ps.setString(1, assignName);
			
			while(rs.next()){
				Index index = new Index();
				index.setAssignName(rs.getString("assignName"));
				index.setAssignProject(rs.getString("project"));
				index.setAssignTitle(rs.getString("title"));
				indexs.add(index);
			}
			rs.close();
			ps.close();

	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return indexs;
	}

}
