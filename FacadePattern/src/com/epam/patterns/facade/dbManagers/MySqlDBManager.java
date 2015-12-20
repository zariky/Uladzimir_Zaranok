package com.epam.patterns.facade.dbManagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBManager {

	public static Connection getMySqlDBConnection() {
		/*String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Persons";
		String username = "root";
		String password = "";
	    
	    try {
	    	Class.forName(driver);
    		return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		return null;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void generateMySqlPDFReport(String tableName, Connection con) {
		System.out.println("MySql PDF report has been created");
	}

	public void generateMySqlHTMLReport(String tableName, Connection con) {
		System.out.println("MySql HTML report has been created");
	}

}
