package com.harold.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testDbervlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variable
		String user = "springstudent";
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&allowPublicKeyRetrieval=true";
		String driver = "com.mysql.jdbc.Driver";

		PrintWriter out = response.getWriter();
		
		// get connection
		try {
			
			out.println("Connecting to the DB");
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Connection successful");
			
			con.close();
			
			
		}catch(Exception e) {
			out.println("Error connecting to the DB");
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
