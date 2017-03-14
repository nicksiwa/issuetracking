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
		try {
			String query = "select * from issue where assign=? order by updateDate desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, assign);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setAssign(rs.getString("assign"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				index.setStatus(rs.getString("status"));
				
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

				} catch (ParseException e) {
				    e.printStackTrace();
				}
				
				index.setDueDateChecker(result);
				indexs.add(index);

				if (index.getStatus().equals("Resolved")||index.getStatus().equals("Closed")) {
					indexs.remove(index);
					
				}
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return indexs;
	}

	@Override
	public List<Index> getReportByMe(String report) {
		List<Index> reports = new ArrayList<Index>();
		try {
			String query = "select * from issue where reporter=? order by updateDate desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, report);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setReporter(rs.getString("reporter"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				index.setStatus(rs.getString("status"));
				
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

				} catch (ParseException e) {
				    e.printStackTrace();
				}
				
				index.setDueDateChecker(result);
				reports.add(index);

				if (index.getStatus().equals("Resolved")||index.getStatus().equals("Closed")) {
					reports.remove(index);
				}
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reports;
	}

	@Override
	public List<Index> getResolveIssue() {
		List<Index> resolves = new ArrayList<Index>();
		try {
			String query = "select * from issue where status='Resolved' order by updateDate desc";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setReporter(rs.getString("reporter"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				
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

				} catch (ParseException e) {
				    e.printStackTrace();
				}
				
				index.setDueDateChecker(result);
				
				resolves.add(index);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resolves;
	}

	@Override
	public List<Index> getRecentlyModified() {
		List<Index> recents = new ArrayList<Index>();
		try{
			String query = "select * from issue order by updateDate desc";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setReporter(rs.getString("reporter"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				recents.add(index);
			}
			rs.close();
			statement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return recents;
	}

	@Override
	public List<Index> getProjectByUser(String assign) {
		List<Index> projects = new ArrayList<Index>();
		try{
			String query = "select project.status, project.projectName, person.firstName, project.projectID from person join assign on person.personId = assign.person_ID and CONCAT_WS (' ',firstName, lastName) like ? join project on assign.project_ID = project.projectID";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, assign);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Index index = new Index();
				index.setProjectID(rs.getInt("projectID"));
				index.setProject(rs.getString("projectName"));
				index.setProjectStatus(rs.getString("status"));
				projects.add(index);
				
				if (index.getProjectStatus().equals("Closed")) {
					projects.remove(index);
				}
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public List<Index> getPublicProject() {
		List<Index> publics = new ArrayList<Index>();
		try{
			String query = "select * from project where viewStatus='Public'";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				Index index = new Index();
				index.setProjectID(rs.getInt("projectID"));
				index.setProject(rs.getString("projectName"));
				index.setProjectStatus(rs.getString("status"));
				publics.add(index);
				
				if (index.getProjectStatus().equals("Closed")) {
					publics.remove(index);
				}
			}
			rs.close();
			statement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return publics;
	}

	@Override
	public List<Index> getUnassignIssue() {
		List<Index> unassign = new ArrayList<Index>();
		try{
			String query = "select * from issue where assign='-' order by updateDate desc";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setProject(rs.getString("project"));
				index.setReporter(rs.getString("reporter"));
				index.setTitle(rs.getString("title"));
				index.setUpdateDate(rs.getString("updateDate"));
				index.setStatus(rs.getString("status"));
				
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

				} catch (ParseException e) {
				    e.printStackTrace();
				}
				
				index.setDueDateChecker(result);
				
				unassign.add(index);
				
				if (index.getStatus().equals("Resolved")||index.getStatus().equals("Closed")) {
					unassign.remove(index);
				}
			}
			rs.close();
			statement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return unassign;
	}

	@Override
	public List<Index> getLabelByIssueId(String user) {
		List<Index> label = new ArrayList<Index>();
		try{
			String query = "select label.labelName, label.labelType,issue.issueID from issue join assignlabel on issue.issueID = assignlabel.issueID join label on assignlabel.labelID = label.labelID";
			PreparedStatement ps = conn.prepareStatement(query);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Index index = new Index();
				index.setIssueID(rs.getInt("issueID"));
				index.setLabelName(rs.getString("labelName"));
				index.setLabelType(rs.getString("labelType"));	
				label.add(index);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return label;
	}

}
