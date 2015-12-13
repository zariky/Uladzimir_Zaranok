package com.epam.abstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBasetFileDataManager implements IDataManager {

	private static final String WRITE_OBJECT_SQL = "INSERT INTO person(name, address, faculty, salary, type) VALUES (?, ?, ?, ?, ?)";
	private static final String READ_PERSON_BY_NAME_SQL = "SELECT * FROM person WHERE name = ?";
	private static final String READ_PERSON_SQL = "SELECT * FROM person WHERE ID = (SELECT MAX(ID) FROM person)";
	
	@Override
	public void writePerson(Person person) {
		PreparedStatement pstmt = null;
		try {
			pstmt = getConnection().prepareStatement(WRITE_OBJECT_SQL);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getAddress());
			pstmt.setString(3, person.getFaculty());
			pstmt.setInt(4, person.getSalary());
			pstmt.setString(5, person.getClass().getSimpleName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { 
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Person readPerson() {
		Statement stmt = null;
		Person person = null;
		AbstractFactory personFactory = FactoryProducer.getFactory("person");
		try {
			stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(READ_PERSON_SQL);
			while (rs.next()) {
				String name = rs.getString(1);
				String address = rs.getString(2);
				String faculty = rs.getString(3);
				int salary = rs.getInt(4);
				String personType = rs.getString(5);
				person = personFactory.getPersonFactory(personType);
				person.setName(name);
				person.setAddress(address);
				person.setFaculty(faculty);
				person.setSalary(salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return person;
	}

	@Override
	public Person readPerson(String persoName) {
		PreparedStatement pstmt = null;
		Person person = null;
		List<Person> personsList = new ArrayList<Person>();
		AbstractFactory personFactory = FactoryProducer.getFactory("person");
		try {
			pstmt = getConnection().prepareStatement(READ_PERSON_BY_NAME_SQL);
			pstmt.setString(1, persoName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String address = rs.getString(2);
				String faculty = rs.getString(3);
				int salary = rs.getInt(4);
				String personType = rs.getString(5);
				person = personFactory.getPersonFactory(personType);
				person.setName(name);
				person.setAddress(address);
				person.setFaculty(faculty);
				person.setSalary(salary);
				personsList.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return personsList.size() > 0 ? personsList.get(0) : null;
	}
	
	private static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Persons";
		String username = "root";
		String password = "";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

}
