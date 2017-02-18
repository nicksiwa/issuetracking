package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.siwa.model.AssignLabel;
import com.siwa.util.DBUtil;

public class AssignLabelDAOImplementation implements AssignLabelDAO{
	private Connection conn;

	public AssignLabelDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addAssignLabel(AssignLabel assignLabel) {
		try{
			String query = "set @label_id = (select label.labelID from label where label.labelName = ?)";
			String query3 = "insert into assignlabel (labelID,issueID) values (@label_id,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps.setString(1, assignLabel.getLabelName());
			ps3.setInt(1, assignLabel.getIssueID());
			ps.executeQuery();
			ps3.executeUpdate();
			ps.close();
			ps3.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAssignLabel(int assignLabelID) {
		try{
			String query = "delete from assignlabel where assignLabelID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, assignLabelID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AssignLabel> getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssignLabel> getIssue() {
		// TODO Auto-generated method stub
		return null;
	}

}
