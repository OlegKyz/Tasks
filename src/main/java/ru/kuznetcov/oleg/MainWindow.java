package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class MainWindow extends JFrame {

	private JPanel mainPanel;
	private JPanel tasksPanel;
	private JPanel buttonsPanel;
	private JButton addButton, deleteButton;
	private List<TaskPanel> tasksPanelList;

	private JFrame addTaskFrame = null;

	public MainWindow() {
		tasksPanelList = new ArrayList<TaskPanel>();
		List<Task> tasks = new TaskDAO().findAll();

		tasksPanel = new JPanel();
		tasksPanel.setLayout(new GridLayout(0, 1));

		for (Task task : tasks) {
			List<Subtask> subtasks = new SubtaskDAO().findByMainTaskId(task.getId());
			TaskPanel buf = new TaskPanel(task, subtasks);
			tasksPanel.add(buf);
			tasksPanelList.add(buf);
		}

		buttonsPanel = new JPanel();
		addButton = new JButton("Add");
		deleteButton = new JButton("Delete");
		buttonsPanel.add(addButton);
		buttonsPanel.add(deleteButton);

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

		deleteButton.addActionListener(event -> {
			for (TaskPanel task : tasksPanelList) {
				if (task.isSelected() && !task.isDeleted()) {
					task.setDeleted(true);
					new TaskDAO().delete(task.getId());
					tasksPanel.remove(task);
				}
			}
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