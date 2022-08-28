package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SubtasksShowWindow extends JFrame {
	private JPanel mainPanel;

	public SubtasksShowWindow(List<Subtask> subtasks) {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		for (Subtask subtask : subtasks) {
			mainPanel.add(new SubtaskPanel(subtask));
		}
		add(mainPanel);
		pack();
	}
}