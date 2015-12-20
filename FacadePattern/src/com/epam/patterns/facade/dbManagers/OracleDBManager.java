package com.epam.patterns.facade.dbManagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBManager {

	public static Connection getOracleDBConnection() {
		/*String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:scorpian";
	    String username = "userName";
	    String password = "pass";

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

	public void generateOraclePDFReport(String tableName, Connection con) {
		System.out.println("Oracle PDF report has been created");
	}

	public void generateOracleHTMLReport(String tableName, Connection con) {
		System.out.println("Oracle HTML report has been created");
	}

}
