package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class Task {
	private int id;
	private String description;
	private String name;

	public Task(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "id = " + id + ", description = " + description;
	}

	static public JPanel getTaskAddPanel(JPanel tasksPanel) {
		return new JPanel() {
			//private JPanel addPanel;
			private JTextField nameField;
			private JTextField descriptionField;
			private JButton saveButton;
			private JPanel tasksPanel;

			{
				this.tasksPanel = tasksPanel;
				nameField = new JTextField(20);
				descriptionField = new JTextField(20);

				saveButton = new JButton("Save");

				//addPanel = new JPanel();
				// addPanel.add(nameField);
				// addPanel.add(descriptionField);
				// addPanel.add(saveButton);

				add(nameField);
				add(descriptionField);
				add(saveButton);

				saveButton.addActionListener(event -> {
					Task task = new Task(-1, nameField.getText(), 
						descriptionField.getText());
					new TaskDAO().create(task);
					//this.tasksPanel.add(new TaskPanel(task, null));
					nameField.setText("");
					descriptionField.setText("");
				});
			}
		};
		// JPanel addPanel;
		// JTextField nameField;
		// JTextField descriptionField;
		// JButton saveButton;

		// nameField = new JTextField(20);
		// descriptionField = new JTextField(20);

		// saveButton = new JButton("Save");

		// addPanel = new JPanel();
		// addPanel.add(nameField);
		// addPanel.add(descriptionField);
		// addPanel.add(saveButton);

		// saveButton.addActionListener(event -> {
		// 	new TaskDAO().create(new Task(nameField.getText(), 
		// 		descriptionField.getText()));
		// 	nameField.setText("");
		// 	descriptionField.setText("");
		// });

		// return addPanel;
	}
}