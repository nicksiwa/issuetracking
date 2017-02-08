package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Label;
import com.siwa.util.DBUtil;

public class LabelDAOImplementation implements LabelDAO {
	private Connection conn;

	public LabelDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addLabel(Label label) {
		try{
			String query = "insert into label (labelName, labelType, labelProject) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, label.getLabelName());
			ps.setString(2, label.getLabelType());
			ps.setInt(3, label.getLabelProject());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteLabel(int labelID) {
		try{
			String query = "delete from label where labelID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, labelID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Label> getAllLabel() {
		List<Label> labels = new ArrayList<Label>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from label");
			while(rs.next()){
				Label label = new Label();
				label.setLabelID(rs.getInt("labelID"));
				label.setLabelName(rs.getString("labelName"));
				label.setLabelType(rs.getString("labelType"));
				label.setLabelProject(rs.getInt("labelProject"));
				labels.add(label);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return labels;
	}

}
