package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class NewTaskWindow extends JFrame {

	private JTextField nameField;
	private JTextField descriptionField;
	private JButton saveButton;
	private JPanel mainPanel;

	public NewTaskWindow(MainWindow mainWindow) {
		nameField = new JTextField(20);
		descriptionField = new JTextField(20);

		saveButton = new JButton("Save");

		mainPanel = new JPanel();
		mainPanel.add(nameField);
		mainPanel.add(descriptionField);
		mainPanel.add(saveButton);

		add(mainPanel);
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