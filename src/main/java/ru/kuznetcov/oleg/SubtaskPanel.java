package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SubtaskPanel extends JPanel {
	public SubtaskPanel(Subtask subtask) {
		add(new JLabel(new Integer(subtask.getId()).toString()));
		add(new JLabel(new Integer(subtask.getMainTaskId()).toString()));
		add(new JLabel(subtask.getDescription()));
		add(new JLabel(new Integer(subtask.getCurrentResult()).toString()));
		add(new JLabel(new Integer(subtask.getFinishResult()).toString()));
	}
}