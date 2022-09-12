package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SubtaskCreateWindow extends JFrame {

	public SubtaskCreateWindow(SubtasksShowWindow parentWindow) {
		setLayout(new GridLayout(2, 1));

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 2));

		JLabel nameLabel = new JLabel("Name");
		JTextField nameField = new JTextField(20);
		contentPanel.add(nameLabel);
		contentPanel.add(nameField);

		JLabel descriptionLabel = new JLabel("Description");
		JTextField descriptionField = new JTextField(20);
		contentPanel.add(descriptionLabel);
		contentPanel.add(descriptionField);

		JLabel currentResultLabel = new JLabel("Current result");
		JTextField currentResultField = new JTextField(20);
		contentPanel.add(currentResultLabel);
		contentPanel.add(currentResultField);

		JLabel finishResultLabel = new JLabel("Finish result");
		JTextField finishResultField = new JTextField(20);
		contentPanel.add(finishResultLabel);
		contentPanel.add(finishResultField);

		JPanel buttonPanel = new JPanel();
		JButton saveButton = new JButton("Save");
		buttonPanel.add(saveButton);

		add(contentPanel);
		add(buttonPanel);
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