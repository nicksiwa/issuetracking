package com.siwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.siwa.model.Person;
import com.siwa.util.DBUtil;

public class PersonDAOImplementation implements PersonDAO {

	private Connection conn;

	public PersonDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addPerson(Person person) {
		try {
			String query = "insert into Person (firstName, lastName, birthDate, gender, address, tel, position) values (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setDate(3, new java.sql.Date (person.getBirthDate().getTime()));
			preparedStatement.setString(4, person.getGender());
			preparedStatement.setString(5, person.getAddress());
			preparedStatement.setString(6, person.getTel());
			preparedStatement.setString(7, person.getPosition());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePerson(int personId) {
		try {
			String query = "delete from Person where personId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, personId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	


	
	@Override
	public void updatePerson(Person person) {
		try {
			String query = "update Person set firstName=?, lastName=?, birthDate=?, gender=?, address=?, tel=?, position=? where personId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setDate(3, new java.sql.Date (person.getBirthDate().getTime()));
			preparedStatement.setString(4, person.getGender());
			preparedStatement.setString(5, person.getAddress());
			preparedStatement.setString(6, person.getTel());
			preparedStatement.setString(7, person.getPosition());
			preparedStatement.setInt(8, person.getPersonId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Person");
			while (resultSet.next()) {
				Person person = new Person();
				person.setPersonId(resultSet.getInt("personId"));
				person.setFirstName(resultSet.getString("firstName"));
				person.setLastName(resultSet.getString("lastName"));
				person.setBirthDate(resultSet.getDate("birthDate"));
				person.setGender(resultSet.getString("gender"));
				person.setAddress(resultSet.getString("address"));
				person.setTel(resultSet.getString("tel"));
				person.setPosition(resultSet.getString("position"));
				persons.add(person);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

	@Override
	public Person getPersonById(int personId) {
		Person person = new Person();
		try {
			String query = "select * from Person where personId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, personId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				person.setPersonId(resultSet.getInt("personId"));
				person.setFirstName(resultSet.getString("firstName"));
				person.setLastName(resultSet.getString("LastName"));
				person.setBirthDate(resultSet.getDate("birthDate"));
				person.setGender(resultSet.getString("gender"));
				person.setAddress(resultSet.getString("address"));
				person.setTel(resultSet.getString("tel"));
				person.setPosition(resultSet.getString("position"));

			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

}