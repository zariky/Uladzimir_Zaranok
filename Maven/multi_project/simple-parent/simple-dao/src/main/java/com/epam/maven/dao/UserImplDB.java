package com.epam.maven.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.maven.dbmanager.ConnectionManager;

public class UserImplDB {
	public static final String SELECT_ID_USERS = "SELECT id, name FROM users";
	
	public static List<String> getUsersFromDB() {
		List<String> issueList = new ArrayList<String>();
		try(Connection currentCon = ConnectionManager.getConnection();
				Statement stmt = currentCon.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ID_USERS);) {
			while (rs.next()) {
				issueList.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issueList;
	}
}
