package com.epam.patterns.facade.facadeManagers;

import java.sql.Connection;
import com.epam.patterns.facade.dbManagers.MySqlDBManager;
import com.epam.patterns.facade.dbManagers.OracleDBManager;

public class FacadeDBManager {
	
	public static enum DBTypes {
		MYSQL, ORACLE;
	}
	
	public static enum ReportTypes {
		HTML, PDF;
	}
	
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
		Connection con = null;
		switch (dbType) {
		case MYSQL:
			con = MySqlDBManager.getMySqlDBConnection();
			MySqlDBManager mySqlManager = new MySqlDBManager();
			switch (reportType) {
			case HTML:
				mySqlManager.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				mySqlManager.generateMySqlPDFReport(tableName, con);
				break;
			}
			break;
		case ORACLE:
			con = OracleDBManager.getOracleDBConnection();
			OracleDBManager oracleManager = new OracleDBManager();
			switch (reportType) {
			case HTML:
				oracleManager.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				oracleManager.generateOraclePDFReport(tableName, con);
				break;
			}
			break;
		}
	}
}
