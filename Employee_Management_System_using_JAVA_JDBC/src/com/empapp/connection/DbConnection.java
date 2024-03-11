package com.empapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static Connection conn;

	public static Connection createDBConnection() {

		try {
			// load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection

			String url = "jdbc:mysql://localhost:3306/project2024";
			String userName = "root";
			String password = "root";

			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

		return conn;
	}

}
