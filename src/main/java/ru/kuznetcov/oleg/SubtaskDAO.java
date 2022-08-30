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
	private final String SQL_SELECT_MAIN_TASK_ID =
		"SELECT * FROM Subtasks WHERE Main_task_id = ?";
	private final String SQL_INSERT_SUBTASK =
		"INSERT INTO Subtask(Main_task_id, Name, Description, Current_result, Finish_result) VALUES(?, ?, ?, ?, ?)";

	public List<Subtask> findAll() {
		List<Subtask> subtasks = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection(DBName)) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_SUBTASKS);
			while (rs.next()) {
				int id = rs.getInt("Id");
				int mainTaskId = rs.getInt("Main_task_id");
				String description = rs.getString("Description");
				String name = rs.getString("Name");
				int currentResult = rs.getInt("Current_result");
				int finishResult = rs.getInt("Finish_result");
				subtasks.add(new Subtask(id, mainTaskId, name, description,
						currentResult, finishResult));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subtasks;
	}

	public List<Subtask> findByMainTaskId(Integer mainTaskId) {
		List<Subtask> subtasks = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection(DBName);
			PreparedStatement statement = connection.prepareStatement(SQL_SELECT_MAIN_TASK_ID)) {

			statement.setInt(1, mainTaskId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("Id");
				int bufMainTaskId = rs.getInt("Main_task_id");
				String name = rs.getString("Name");
				String description = rs.getString("Description");
				int currentResult = rs.getInt("Current_result");
				int finishResult = rs.getInt("Finish_result");
				subtasks.add(new Subtask(id, bufMainTaskId, name, description,
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
		boolean rs = false;
		try (Connection connection = ConnectorDB.getConnection(DBName);
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SUBTASK)) {

			statement.setInt(1, entity.getMainTaskId());
			statement.setString(2, entity.getName());
			statement.setString(3, entity.getDescription());
			statement.setInt(4, entity.getCurrentResult());
			statement.setInt(5, entity.getFinishResult());
			rs = statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Subtask update(Subtask entity) {
		throw new UnsupportedOperationException();
	}
}