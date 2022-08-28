package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class TaskPanel extends JPanel {

	private JLabel taskName;
	private JLabel description;
	private JLabel progress;
	private JButton showDetails;
	private SubtasksShowWindow subtasksWindow;

	public TaskPanel(Task task, List<Subtask> subtasks) {
		taskName = new JLabel(task.getName());
		description = new JLabel(task.getDescription());
		progress = new JLabel("100");
		showDetails = new JButton("Show details");

		add(taskName);
		add(description);
		add(progress);
		add(showDetails);

		showDetails.addActionListener(event -> {
			if (subtasksWindow == null) {
				subtasksWindow = new SubtasksShowWindow(subtasks);
			}
			subtasksWindow.setVisible(true);
		});
	}
}