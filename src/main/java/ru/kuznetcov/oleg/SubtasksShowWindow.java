package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class SubtasksShowWindow extends JFrame {
	private JPanel mainPanel;
	private JButton addButton;
	private JButton deleteButton;
	private JPanel buttonPanel;
	private JPanel subtasksPanel;
	private SubtaskCreateWindow subtaskCreateWindow;
	private int mainTaskId;
	private List<SubtaskPanel> subtasksPanelList;

	public SubtasksShowWindow(List<Subtask> subtasks, int mainTaskId) {
		this.mainTaskId = mainTaskId;
		mainPanel = new JPanel();

		subtasksPanel = new JPanel();
		subtasksPanel.setLayout(new GridLayout(0, 1));

		subtasksPanelList = new ArrayList<SubtaskPanel>();
		for (Subtask subtask : subtasks) {
			SubtaskPanel buf = new SubtaskPanel(subtask);
			subtasksPanel.add(buf);
			subtasksPanelList.add(buf);
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

		deleteButton.addActionListener(event -> {
			for (SubtaskPanel subtask : subtasksPanelList) {
				if (subtask.isSelected() && !subtask.isDeleted()) {
					subtask.setDeleted(true);
					new SubtaskDAO().delete(subtask.getId());
					subtasksPanel.remove(subtask);
				}
			}
		});
	}

	public JPanel getSubtasksPanel() {
		return subtasksPanel;
	}

	public int getMainTaskId() {
		return mainTaskId;
	}
}