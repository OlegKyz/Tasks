package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class MainWindow extends JFrame {

	private JPanel mainPanel;
	private JPanel tasksPanel;
	private JPanel buttonsPanel;
	private JButton addButton;

	private JFrame addTaskFrame = null;

	public MainWindow() {
		List<Task> tasks = new TaskDAO().findAll();

		tasksPanel = new JPanel();
		tasksPanel.setLayout(new GridLayout(0, 1));

		for (Task task : tasks) {
			List<Subtask> subtasks = new SubtaskDAO().findByMainTaskId(task.getId());
			tasksPanel.add(new TaskPanel(task, subtasks));
		}

		buttonsPanel = new JPanel();
		addButton = new JButton("Add");
		buttonsPanel.add(addButton);

		mainPanel = new JPanel();
		mainPanel.add(tasksPanel);
		mainPanel.add(buttonsPanel);
		add(mainPanel);
		pack();

		addButton.addActionListener(event -> {
			if (addTaskFrame == null) {
				addTaskFrame = new NewTaskWindow(this);
			}
			addTaskFrame.setVisible(true);
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	JPanel getTasksPanel() {
		return tasksPanel;
	}
}