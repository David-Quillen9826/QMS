package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = System.getenv("Project4_URL");
		String username = System.getenv("Project4_USERNAME");
		String password = System.getenv("Project4_PASSWORD");
		return DriverManager.getConnection(url, username, password);
	}
}

