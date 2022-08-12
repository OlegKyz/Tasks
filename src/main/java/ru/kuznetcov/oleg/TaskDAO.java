package ru.kuznetcov.oleg;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class TaskDAO implements AbstractDAO<Integer, Task> {
	private final String DBName = "Task1";
	private final String SQL_SELECT_ALL_TASKS =
		"SELECT * FROM Tasks";
	private final String SQL_SELECT_TASK_ID =
		"SELECT * FROM Tasks WHERE Id = ?";

	public List<Task> findAll() {
		List<Task> tasks = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection(DBName)) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_TASKS);
			while (rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String description = rs.getString("Description");
				tasks.add(new Task(id, name, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	public Task findEntityById(Integer id) {
		throw new UnsupportedOperationException();
	}

	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	public boolean delete(Task entity) {
		throw new UnsupportedOperationException();
	}

	public boolean create(Task entity) {
		throw new UnsupportedOperationException();
	}

	public Task update(Task entity) {
		throw new UnsupportedOperationException();
	}
}