package com.harold.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc<T> {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to DB");
			Connection conn = DriverManager.getConnection(jdbcUrl,user, password);
			System.out.println("Successful");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
