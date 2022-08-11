package ru.kuznetcov.oleg;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class SubtaskDAO implements AbstractDAO<Integer, Subtask> {
	private final String DBName = "Task1";
	private final String SQL_SELECT_ALL_SUBTASKS =
		"SELECT * FROM Subtasks";
	private final String SQL_SELECT_SUBTASK_ID =
		"SELECT * FROM Subtasks WHERE Id = ?";

	public List<Subtask> findAll() {
		List<Subtask> subtasks = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection(DBName)) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_SUBTASKS);
			while (rs.next()) {
				int id = rs.getInt("Id");
				int mainTaskId = rs.getInt("Main_task_id");
				String description = rs.getString("Description");
				int currentResult = rs.getInt("Current_result");
				int finishResult = rs.getInt("Finish_result");
				subtasks.add(new Subtask(id, mainTaskId, description,
						currentResult, finishResult));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subtasks;
	}

	public Subtask findEntityById(Integer id) {
		throw new UnsupportedOperationException();
	}

	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	public boolean delete(Subtask entity) {
		throw new UnsupportedOperationException();
	}

	public boolean create(Subtask entity) {
		throw new UnsupportedOperationException();
	}

	public Subtask update(Subtask entity) {
		throw new UnsupportedOperationException();
	}
}