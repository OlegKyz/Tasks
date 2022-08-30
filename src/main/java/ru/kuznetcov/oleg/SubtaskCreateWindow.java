package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SubtaskCreateWindow extends JFrame {

	public SubtaskCreateWindow(SubtasksShowWindow parentWindow) {
		JPanel mainPanel = new JPanel();

		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(0, 2));

		JLabel nameLabel = new JLabel("Name");
		JTextField nameField = new JTextField();
		dataPanel.add(nameLabel);
		dataPanel.add(nameField);

		JLabel descriptionLabel = new JLabel("Description");
		JTextField descriptionField = new JTextField();
		dataPanel.add(descriptionLabel);
		dataPanel.add(descriptionField);

		JLabel currentResultLabel = new JLabel("Current result");
		JTextField currentResultField = new JTextField();
		dataPanel.add(currentResultLabel);
		dataPanel.add(currentResultField);

		JLabel finishResultLabel = new JLabel("Finish result");
		JTextField finishResultField = new JTextField();
		dataPanel.add(finishResultLabel);
		dataPanel.add(finishResultField);

		JPanel buttonPanel = new JPanel();
		JButton saveButton = new JButton("Save");
		buttonPanel.add(saveButton);

		mainPanel.add(dataPanel);
		mainPanel.add(buttonPanel);
		add(mainPanel);
		pack();

		saveButton.addActionListener(event -> {
			Subtask subtask = new Subtask(
				-1,
				parentWindow.getMainTaskId(),
				nameField.getText(),
				descriptionField.getText(),
				Integer.valueOf(currentResultField.getText()),
				Integer.valueOf(finishResultField.getText())
			);
			new SubtaskDAO().create(subtask);
			parentWindow.getSubtasksPanel().add(new SubtaskPanel(subtask));
			nameField.setText("");
			descriptionField.setText("");
			currentResultField.setText("");
			finishResultField.setText("");
		});
	}
}