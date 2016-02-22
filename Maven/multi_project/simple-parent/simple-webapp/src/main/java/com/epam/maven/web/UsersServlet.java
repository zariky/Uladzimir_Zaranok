package com.epam.maven.web;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.epam.maven.dao.UserImplDB;

public class UsersServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<String> issueList = UserImplDB.getUsersFromDB();
    
	PrintWriter out = response.getWriter();
        try {
	    out.println("Users DAO");
	    for (String usr : issueList) {
	    	out.println(usr);
		}
	} catch( Exception e ) {
	    out.println( "Error Retrieving Forecast: " + e.getMessage() );
	}
        out.flush();
        out.close();
    }
}