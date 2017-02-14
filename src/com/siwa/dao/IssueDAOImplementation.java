package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.siwa.model.Comment;
import com.siwa.model.Issue;
import com.siwa.util.DBUtil;

public class IssueDAOImplementation implements IssueDAO {
	
	private Connection conn;
	
	
	

	public IssueDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addIssue(Issue issue) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "insert into issue (project,assign,title,description,severity,priority,dueDate,updateDate,status,reporter,createDate) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getProject());
			ps.setString(2, issue.getAssign());
			ps.setString(3, issue.getTitle());
			ps.setString(4, issue.getDescription());
			ps.setString(5, issue.getSeverity());
			ps.setString(6, issue.getPriority());
			ps.setDate(7,new java.sql.Date (issue.getDueDate().getTime()));
			ps.setTimestamp(8, new Timestamp(date.getTime()));
			ps.setString(9, issue.getStatus());
			ps.setString(10, issue.getReporter());
			ps.setTimestamp(11, new Timestamp(date.getTime()));
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteIssue(int issueID) {
		try{
			String query = "delete from issue where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateIssue(Issue issue) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "update issue set project=?, assign=?, title=?, description=?, severity=?, priority=?, dueDate=?, updateDate=?, status=?, reporter=? where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, issue.getProject());
			ps.setString(2, issue.getAssign());
			ps.setString(3, issue.getTitle());
			ps.setString(4, issue.getDescription());
			ps.setString(5, issue.getSeverity());
			ps.setString(6, issue.getPriority());
			ps.setDate(7,new java.sql.Date (issue.getDueDate().getTime()));
			ps.setTimestamp(8, new Timestamp(date.getTime()));
			ps.setString(9, issue.getStatus());
			ps.setString(10, issue.getReporter());
			ps.setInt(11, issue.getIssueID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Issue> getAllIssue() {
		List<Issue> issues = new ArrayList<Issue>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from issue");
			while(rs.next()){
				Issue issue = new Issue();
				issue.setIssueID(rs.getInt("issueID"));
				issue.setProject(rs.getString("project"));
				issue.setAssign(rs.getString("assign"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				issue.setCreateDate(rs.getTimestamp("createDate"));
				issues.add(issue);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issues;
	}

	@Override
	public Issue getAssignById(int issueID) {
		Issue issue = new Issue();
		try{
			String query = "select * from issue where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				issue.setIssueID(rs.getInt("issueID"));
				issue.setProject(rs.getString("project"));
				issue.setAssign(rs.getString("assign"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issue;
	}

	

	@Override
	public List<Comment> getCommentByIssue(int issueID) {
		List<Comment> comments = new ArrayList<Comment>();
		try{
			String query = "select * from comment where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setCommentDetail(rs.getString("commentDetail"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comment.setCommentStatus(rs.getString("commentStatus"));
				comments.add(comment);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comments;
	}

	@Override
	public void setStatusAssign(Issue issue) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "update issue set updateDate=?, status='Assign' where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1, new Timestamp(date.getTime()));
			ps.setInt(2, issue.getIssueID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	
	}

	@Override
	public void setStatusFeedback(Issue issue) {
		java.util.Date date= new java.util.Date();
		
		try{
			String query = "update issue set updateDate=?, status='Feedback' where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1, new Timestamp(date.getTime()));
			ps.setInt(2, issue.getIssueID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void setStatusConfirmed(Issue issue) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "update issue set updateDate=?, status='Confirmed' where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1, new Timestamp(date.getTime()));
			ps.setInt(2, issue.getIssueID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void setStatusResolved(Issue issue) {
		java.util.Date date= new java.util.Date();
		try{
			String query = "update issue set updateDate=?, status='Resolved' where issueID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setTimestamp(1, new Timestamp(date.getTime()));
			ps.setInt(2, issue.getIssueID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Issue> getPersonByProject(int issueID) {
		List<Issue> issuess = new ArrayList<Issue>();
		try{
			String query = "select CONCAT_WS (' ',firstName, lastName) as full_name from project join assign on project.projectID = assign.project_ID and project.projectID=? join person on assign.person_ID = person.personId";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, issueID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setAssign(rs.getString("full_name"));
				issuess.add(issue);
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issuess;
	}

	@Override
	public List<Issue> getIssueByProject(int projectID) {
		List<Issue> projects = new ArrayList<Issue>();
		try{
			String query = "select * from issue join project on issue.project = project.projectName and project.projectID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, projectID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Issue issue = new Issue();
				issue.setIssueID(rs.getInt("issueID"));
				issue.setProject(rs.getString("project"));
				issue.setAssign(rs.getString("assign"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
				projects.add(issue);
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				
				System.out.println(df.format(rs.getDate("dueDate")));
				System.out.println(df.format(date));
				
				String dateStart = df.format(rs.getDate("dueDate"));
				String dateStop = df.format(date); 
				
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

				Date d1 = null;
				Date d2 = null;

				try {
					d1 = format.parse(dateStart);
					d2 = format.parse(dateStop);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					long diffSeconds = diff / 1000 % 60;
					long diffMinutes = diff / (60 * 1000) % 60;
					long diffHours = diff / (60 * 60 * 1000) % 24;
					long diffDays = diff / (24 * 60 * 60 * 1000);

					System.out.print(diffDays + " days, ");
					System.out.print(diffHours + " hours, ");
					System.out.print(diffMinutes + " minutes, ");
					System.out.print(diffSeconds + " seconds.");
					//เอาค่าที่ได้ จะเซฟลงเบสหรือส่งไปแสดงหน้าเว็บก็ได้

				} catch (Exception e) {
					e.printStackTrace();
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
	public Issue getIssueByLastInsert() {
		Issue issue = new Issue();
		try{
			String query = "SET @last_id_in_issue = LAST_INSERT_ID()";
			String query2 = "SELECT * FROM issue WHERE issueID = @last_id_in_issue";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeQuery();
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ResultSet rs = ps2.executeQuery();
			while(rs.next()){
				issue.setIssueID(rs.getInt("issueID"));
				issue.setProject(rs.getString("project"));
				issue.setAssign(rs.getString("assign"));
				issue.setTitle(rs.getString("title"));
				issue.setDescription(rs.getString("description"));
				issue.setSeverity(rs.getString("severity"));
				issue.setPriority(rs.getString("priority"));
				issue.setDueDate(rs.getDate("dueDate"));
				issue.setUpdateDate(rs.getTimestamp("updateDate"));
				issue.setStatus(rs.getString("status"));
				issue.setReporter(rs.getString("reporter"));
			}
			rs.close();
			ps.close();
			ps2.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return issue;
	}



}
