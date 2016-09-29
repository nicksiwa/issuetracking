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
			String query = "insert into comment (description,status,commentTime,userComment) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getStatus());
			ps.setString(3, comment.getCommentTime());	
			ps.setString(4, comment.getUserComment());
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
			String query = "update comment set description=?, status=?, commentTime=?, userComment=? where commentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getStatus());
			ps.setString(3, comment.getCommentTime());
			ps.setString(4, comment.getUserComment());
			ps.setInt(5, comment.getCommentID());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Comment> getAllComment() {
		List<Comment> comments = new ArrayList<Comment>();
		try{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from comment");
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setDescription(rs.getString("description"));
				comment.setStatus(rs.getString("status"));
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
				comments.add(comment);
			}
			rs.close();
			statement.close();
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
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setUserComment(rs.getString("userComment"));
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comment;
	}

}
