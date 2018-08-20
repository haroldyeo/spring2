package com.harold.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc<T> {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
		String user = "springstudent";
		String password = "springstudent";
		
		try {
			System.out.println("Connecting to DB");
			Connection conn = DriverManager.getConnection(jdbcUrl,user, password);
			System.out.println("Successful");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
