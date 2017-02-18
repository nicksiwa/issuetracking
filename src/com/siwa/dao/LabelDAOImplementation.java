package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Index;
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
	@Override
	public Label getLabelByProjectId(int projectID) {
		Label label = new Label();
		try{
			String query = "select * from label where labelProject=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				label.setLabelID(rs.getInt("labelID"));
				label.setLabelName(rs.getString("labelName"));
				label.setLabelType(rs.getString("labelType"));
				label.setLabelProject(rs.getInt("labelProject"));
			}
			ps.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return label;
	}
	@Override
	public List<Label> getAllLabelByProjectId(int projectID) {
		List<Label> labels = new ArrayList<Label>();
		try{
			String query = "select * from label where labelProject=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Label label = new Label();
				label.setLabelID(rs.getInt("labelID"));
				label.setLabelName(rs.getString("labelName"));
				label.setLabelType(rs.getString("labelType"));
				label.setLabelProject(rs.getInt("labelProject"));
				labels.add(label);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return labels;
	}
	@Override
	public List<Label> getAllLabelByProjectName(String projectName) {
		List<Label> labels = new ArrayList<Label>();
		try{
			String query2 = "set @project_id = (select project.projectID from project where project.projectName = ?)";
			String query = "select * from label where labelProject=@project_id";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			PreparedStatement ps = conn.prepareStatement(query);
			ps2.setString(1, projectName);
			ps2.executeQuery();
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Label label = new Label();
				label.setLabelID(rs.getInt("labelID"));
				label.setLabelName(rs.getString("labelName"));
				label.setLabelType(rs.getString("labelType"));
				label.setLabelProject(rs.getInt("labelProject"));
				labels.add(label);
			}
			rs.close();
			ps2.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return labels;
	}
	@Override
	public List<Label> getAllLabelByIssueID(int issueID) {
		List<Label> labels = new ArrayList<Label>();
		try{
			String query = "set @project_id =(select project.projectID from project join issue on issue.project = project.projectName and issue.issueID = ?)";
			String query2 = "select * from label where labelProject=@project_id";
			PreparedStatement ps = conn.prepareStatement(query);
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps.setInt(1, issueID);
			ps.executeQuery();
			ResultSet rs = ps2.executeQuery();
			while(rs.next()){
				Label label = new Label();
				label.setLabelID(rs.getInt("labelID"));
				label.setLabelName(rs.getString("labelName"));
				label.setLabelType(rs.getString("labelType"));
				label.setLabelProject(rs.getInt("labelProject"));
				labels.add(label);
			}
			rs.close();
			ps2.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return labels;
	}
	@Override
	public List<Label> getAssignLabel(int issueID) {
		List<Label> labelAssigns = new ArrayList<Label>();
		try{
			String query = "select label.labelID,label.labelName,label.labelType,label.labelProject from label join assignlabel on label.labelID = assignlabel.labelID join issue on assignlabel.issueID = issue.issueID and issue.issueID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Label label = new Label();
				label.setLabelID(rs.getInt("labelID"));
				label.setLabelName(rs.getString("labelName"));
				label.setLabelType(rs.getString("labelType"));
				label.setLabelProject(rs.getInt("labelProject"));
				labelAssigns.add(label);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return labelAssigns;
	}

}
