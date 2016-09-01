package com.siwa.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.siwa.util.DBUtil;
import com.siwa.model.BugFix;

public class BugFixDAOImplementation implements BugFixDAO {

	private Connection conn;

	public BugFixDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addBug(BugFix bug) {
		try {
			String query = "insert into bugfix (title, detail, workPer, resPerson) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, bug.getTitle());
			preparedStatement.setString(2, bug.getDetail());
			preparedStatement.setString(3, bug.getWorkPer());
			preparedStatement.setString(4, bug.getResPerson());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteBug(int bugId) {
		try {
			String query = "delete from bugfix where bugId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, bugId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBug(BugFix bug) {
		try {
			String query = "update bugfix set title=?, detail=?, workPer=?, resPerson=? where bugId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, bug.getTitle());
			preparedStatement.setString(2, bug.getDetail());
			preparedStatement.setString(3, bug.getWorkPer());
			preparedStatement.setString(4, bug.getResPerson());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<BugFix> getAllBugs() {
		List<BugFix> bugs = new ArrayList<BugFix>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from bugfix");
			while (resultSet.next()) {
				BugFix bug = new BugFix();
				bug.setBugId(resultSet.getInt("bugId"));
				bug.setTitle(resultSet.getString("title"));
				bug.setDetail(resultSet.getString("detail"));
				bug.setWorkPer(resultSet.getString("workPer"));
				bug.setResPerson(resultSet.getString("resPerson"));
				bugs.add(bug);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bugs;
	}

	@Override
	public BugFix getBugById(int bugId) {
		BugFix bug = new BugFix();
		try {
			String query = "select * from bugfix where bugId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, bugId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bug.setBugId(resultSet.getInt("bugId"));
				bug.setTitle(resultSet.getString("title"));
				bug.setDetail(resultSet.getString("detail"));
				bug.setWorkPer(resultSet.getString("workPer"));
				bug.setResPerson(resultSet.getString("resPerson"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bug;
	}

}
