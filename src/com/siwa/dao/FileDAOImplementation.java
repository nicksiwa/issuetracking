package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.File;
import com.siwa.util.DBUtil;

public class FileDAOImplementation implements FileDAO{
	
	private Connection conn;

	public FileDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public File getFileByIssueId(int issueID) {
		File file = new File();
		try{
			String query = "select file_name from test where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				file.setFileName(rs.getString("file_name"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return file;
	}
	@Override
	public List<File> getAllFileByIssueId(int issueID) {
		List<File> files = new ArrayList<File>();
		try{
			String query = "select id,file_name from test where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				File file = new File();
				file.setFileID(rs.getInt("id"));
				file.setFileName(rs.getString("file_name"));
				files.add(file);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return files;
	}

}
