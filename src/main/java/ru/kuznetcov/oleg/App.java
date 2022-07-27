package ru.kuznetcov.oleg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String connectionString = "jdbc:mysql://localhost/Tasks_test_db";
	private static final String login = "root";
	private static final String password = "";

    public static void main( String[] args )
    {
    	System.out.println(System.getProperty("java.class.path"));
        testRun();
    }

    private static void testRun() {
    	try {
    		Class.forName(driverName);
    	} catch (ClassNotFoundException e) {
    		System.out.println("Can't get class");
    		e.printStackTrace();
    		return;
    	}
    	Connection connection = null;
    	try {
    		connection = DriverManager.getConnection(connectionString, login, password);
    	} catch (SQLException e) {
    		System.out.println("Can't get connection");
    		e.printStackTrace();
    		return;
    	}
    	try {
    		connection.close();
    	} catch (SQLException e) {
    		System.out.println("Can't close connection");
    		e.printStackTrace();
    		return;
    	}
    	System.out.println("testRun - OK");
    }
}
