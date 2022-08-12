package ru.kuznetcov.oleg;

public class Task {
	private int id;
	private String description;
	private String name;

	public Task(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "id = " + id + ", description = " + description;
	}
}