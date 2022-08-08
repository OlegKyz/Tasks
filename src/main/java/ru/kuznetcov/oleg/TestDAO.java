package ru.kuznetcov.oleg;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class TestDAO implements AbstractDAO<Integer, Test> {
	private static String SQL_SELECT_ALL_USERS = 
		"SELECT * FROM Test_table";
	private static String SQL_SELECT_USER_ID = 
		"SELECT * FROM Test_table WHERE Id = ?";
	private static String SQL_INSERT_TEST =
		"INSERT INTO Test_table(Id, Str) VALUES(?, ?)";
	private static String SQL_DELETE_TEST =
		"DELETE FROM Test_table WHERE Id = ?";

	public List<Test> findAll() {
		List<Test> tests = new ArrayList<>();
		try (Connection connection = ConnectorDB.getConnection();
			Statement statement = connection.createStatement()) {

			ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
			while (rs.next()) {
				int id = rs.getInt("Id");
				String str = rs.getString("Str");
				tests.add(new Test(str, id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tests;
	}

	public Test findEntityById(Integer id) {
		Test test = null;
		try (Connection connection = ConnectorDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_ID)) {

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				test = new Test(rs.getString("Str"), rs.getInt("Id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return test;
	}

	public boolean delete(Integer id) {
		boolean rs = false; 
		try (Connection connection = ConnectorDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TEST)) {

			statement.setInt(1, id);
			rs = statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean delete(Test entity) {
		throw new UnsupportedOperationException();
	}

	public boolean create(Test entity) {
		boolean rs = false;
		try (Connection connection = ConnectorDB.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT_TEST)) {

			statement.setInt(1, entity.getId());
			statement.setString(2, entity.getStr());
			rs = statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Test update(Test entity) {
		throw new UnsupportedOperationException();
	}
}