package ru.kuznetcov.oleg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class App 
{
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String connectionString = "jdbc:mysql://localhost/Tasks_test_db";
	private static final String login = "root";
	private static final String password = "";

    public static void main( String[] args )
    {
    	//System.out.println(System.getProperty("java.class.path"));
        //testRun();
        initDataBase();
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

    private static void initDataBase() {
    	try {
    		Class.forName(driverName);
    	} catch (ClassNotFoundException e) {
    		System.out.println("Can't get class");
    		e.printStackTrace();
    	}
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

class MainTestWindow extends JFrame {
	private JButton showAllButton;
	private JButton addEntityButton;
	private JButton deleteByIdButton;
	private JPanel buttonPanel;
	private JTextField idText;
	private JTextField strText;
	private JTextArea outArea;

	public MainTestWindow() {
		showAllButton = new JButton("Show All");
		addEntityButton = new JButton("Add entity");
		deleteByIdButton = new JButton("Delete by id");

		idText = new JTextField("id", 20);
		strText = new JTextField("str", 20);
		outArea = new JTextArea(10, 20);

		buttonPanel = new JPanel();
		buttonPanel.add(showAllButton);
		buttonPanel.add(addEntityButton);
		buttonPanel.add(deleteByIdButton);
		buttonPanel.add(idText);
		buttonPanel.add(strText);
		buttonPanel.add(outArea);

		add(buttonPanel);
		pack();

		deleteByIdButton.addActionListener(event -> {
			Integer id = Integer.valueOf(idText.getText());
			new TestDAO().delete(id);
		});

		addEntityButton.addActionListener(event -> {
			Integer id = Integer.valueOf(idText.getText());
			String str = strText.getText();
			new TestDAO().create(new Test(str, id));
		});

		showAllButton.addActionListener(event -> {
			List<Test> tests = new TestDAO().findAll();
			for (Test test : tests) {
				outArea.append(test.toString());
			}
			outArea.append("\n");
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}