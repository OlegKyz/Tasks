package ru.kuznetcov.oleg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class SubtaskPanel extends JPanel {

	private JCheckBox subtaskSelectedChBox;
	private boolean isDeleted = false;
	private int subtaskId;

	public SubtaskPanel(Subtask subtask) {
		subtaskId = subtask.getId();

		subtaskSelectedChBox = new JCheckBox();
		//-1 means that this subtask has been created in this session
		//and id (id is auto_increment) hasn't been downloaded from database
		if (subtaskId == -1) {
			subtaskSelectedChBox.setEnabled(false);
		}

		add(subtaskSelectedChBox);
		add(new JLabel(new Integer(subtask.getId()).toString()));
		add(new JLabel(new Integer(subtask.getMainTaskId()).toString()));
		add(new JLabel(subtask.getDescription()));
		add(new JLabel(new Integer(subtask.getCurrentResult()).toString()));
		add(new JLabel(new Integer(subtask.getFinishResult()).toString()));
	}

	public boolean isSelected() {
		return subtaskSelectedChBox.isSelected();
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deletedStatus) {
		isDeleted = deletedStatus;
	}

	public int getId() {
		return subtaskId;
	}
}