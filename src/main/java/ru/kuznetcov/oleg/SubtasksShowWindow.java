package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SubtasksShowWindow extends JFrame {
	private JPanel mainPanel;
	private JButton addButton;
	private JButton deleteButton;
	private JPanel buttonPanel;
	private JPanel subtasksPanel;
	private SubtaskCreateWindow subtaskCreateWindow;
	private int mainTaskId;

	public SubtasksShowWindow(List<Subtask> subtasks, int mainTaskId) {
		this.mainTaskId = mainTaskId;
		mainPanel = new JPanel();

		subtasksPanel = new JPanel();
		subtasksPanel.setLayout(new GridLayout(0, 1));
		for (Subtask subtask : subtasks) {
			subtasksPanel.add(new SubtaskPanel(subtask));
		}
		addButton = new JButton("Add");
		deleteButton = new JButton("Delete");
		buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);

		mainPanel.add(subtasksPanel);
		mainPanel.add(buttonPanel);
		add(mainPanel);
		pack();

		addButton.addActionListener(event -> {
			if (subtaskCreateWindow == null) {
				subtaskCreateWindow = new SubtaskCreateWindow(this);
			}
			subtaskCreateWindow.setVisible(true);
		});
	}

	public JPanel getSubtasksPanel() {
		return subtasksPanel;
	}

	public int getMainTaskId() {
		return mainTaskId;
	}
}