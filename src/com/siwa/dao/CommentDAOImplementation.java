package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siwa.model.Comment;
import com.siwa.util.DBUtil;

public class CommentDAOImplementation implements CommentDAO {

	private Connection conn;

	public CommentDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addComment(Comment comment) {
		try{
			String query = "insert into comment (description, status, date)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getStatus());		
			ps.setTimestamp(3, new java.sql.Timestamp (comment.getDate().getTime()));
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteComment(int commentID) {
		try{
			String query = "delete from comment where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, commentID);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateComment(Comment comment) {
		try{
			String query = "update comment set description=?, status=?, date=? where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getStatus());		
			ps.setTimestamp(3, new java.sql.Timestamp (comment.getDate().getTime()));
			ps.setInt(4, comment.getCommentID());
			ps.executeUpdate();
			ps.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<Comment>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from comment");
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setDescription(rs.getString("description"));
				comment.setStatus(rs.getString("status"));
				comment.setDate(rs.getTimestamp("date"));
				comments.add(comment);
				
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return comments;
	}

	@Override
	public Comment getCommentById(int commentID) {
		Comment comment = new Comment();
		try{
			String query = "select * from comment where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, commentID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				comment.setCommentID(rs.getInt("commentID"));
				comment.setDescription(rs.getString("description"));
				comment.setStatus(rs.getString("status"));
				comment.setDate(rs.getTimestamp("date"));
			}
			rs.close();
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return comment;
	}



}
