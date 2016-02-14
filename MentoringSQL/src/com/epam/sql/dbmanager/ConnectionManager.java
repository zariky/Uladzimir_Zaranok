package com.epam.sql.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/Facebook";
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String USER_DB = "root";
	private static final String EMPTY = "";
	private static final String ERROR_CLOSE_CONNECTION = "Can't close connection.";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER_DB, EMPTY);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
            System.err.println(ERROR_CLOSE_CONNECTION + e);
		}
	}
}
