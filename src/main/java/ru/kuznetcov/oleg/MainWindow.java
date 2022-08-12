package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class MainWindow extends JFrame {

	private JPanel tasksPanel;

	public MainWindow() {
		List<Task> tasks = new TaskDAO().findAll();

		tasksPanel = new JPanel();
		tasksPanel.setLayout(new GridLayout(0, 1));

		for (Task task : tasks) {
			tasksPanel.add(new TaskPanel(task, null));
		}

		add(tasksPanel);
		pack();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}