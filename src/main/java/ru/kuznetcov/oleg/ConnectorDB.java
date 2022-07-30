package ru.kuznetcov.oleg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String connectionString = "jdbc:mysql://localhost/Tasks_test_db";
	private static final String login = "root";
	private static final String password = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(connectionString, login, password);
	}
}