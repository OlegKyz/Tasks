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
	private JCheckBox taskSelectChBox;

	private boolean isDeleted = false;
	private int taskId;

	public TaskPanel(Task task, List<Subtask> subtasks) {
		taskId = task.getId();
		taskSelectChBox = new JCheckBox();
		//-1 means that this task has been created in this session
		//and id (id is auto_increment) hasn't been downloaded from database
		if (taskId == -1) {
			taskSelectChBox.setEnabled(false);
		}
		taskName = new JLabel(task.getName());
		description = new JLabel(task.getDescription());
		progress = new JLabel("100");
		showDetails = new JButton("Show details");

		add(taskSelectChBox);
		add(taskName);
		add(description);
		add(progress);
		add(showDetails);

		showDetails.addActionListener(event -> {
			if (subtasksWindow == null) {
				subtasksWindow = new SubtasksShowWindow(subtasks, task.getId());
			}
			subtasksWindow.setVisible(true);
		});
	}

	public boolean isSelected() {
		return taskSelectChBox.isSelected();
	}

	public void setDeleted(boolean deletedStatus) {
		isDeleted = deletedStatus;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public int getId() {
		return taskId;
	}
}