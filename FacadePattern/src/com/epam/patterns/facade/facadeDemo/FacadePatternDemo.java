package com.epam.patterns.facade.facadeDemo;

import com.epam.patterns.facade.facadeManagers.FacadeDBManager;

public class FacadePatternDemo {

	public static void main(String[] args) {
		String tableName="Employee";
		
		//generating MySql HTML report and Oracle PDF report using Facade
        FacadeDBManager.generateReport(FacadeDBManager.DBTypes.MYSQL, FacadeDBManager.ReportTypes.HTML, tableName);
        FacadeDBManager.generateReport(FacadeDBManager.DBTypes.ORACLE, FacadeDBManager.ReportTypes.PDF, tableName);
	}

}
