package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class NewTaskWindow extends JFrame {

	private JTextField nameField;
	private JTextField descriptionField;
	private JButton saveButton;
	private JLabel jlName;
	private JLabel jlDescription;

	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JPanel contentPanel;

	public NewTaskWindow(MainWindow mainWindow) {
		setLayout(new GridLayout(2, 1));

		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 2));

		nameField = new JTextField(20);
		jlName = new JLabel("Name");
		descriptionField = new JTextField(20);
		jlDescription = new JLabel("Description");

		contentPanel.add(jlName);
		contentPanel.add(nameField);
		contentPanel.add(jlDescription);
		contentPanel.add(descriptionField);

		buttonPanel = new JPanel();
		saveButton = new JButton("Save");
		buttonPanel.add(saveButton);

		add(contentPanel);
		add(buttonPanel);
		pack();
		
		saveButton.addActionListener(event -> {
			Task task = new Task(-1, nameField.getText(), 
				descriptionField.getText());
			new TaskDAO().create(task);
			mainWindow.getTasksPanel().add(new TaskPanel(task, null));
			mainWindow.repaint();
			nameField.setText("");
			descriptionField.setText("");
		});		
	}
}