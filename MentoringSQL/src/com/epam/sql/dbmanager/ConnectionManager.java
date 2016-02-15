package com.epam.sql.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/Facebook";
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String USER_DB = "root";
	private static final String EMPTY = "";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER_DB, EMPTY);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

