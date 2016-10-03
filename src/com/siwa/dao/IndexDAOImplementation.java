package com.siwa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.siwa.model.Index;
import com.siwa.util.DBUtil;

public class IndexDAOImplementation implements IndexDAO {
	
	private Connection conn;

	public IndexDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public Index getIndexById(String assignName) {
		Index index = new Index();
		try{
			String query = "select project,assign,title from issue where testName=?";

			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Index> getAllIndex() {
		// TODO Auto-generated method stub
		return null;
	}

}
