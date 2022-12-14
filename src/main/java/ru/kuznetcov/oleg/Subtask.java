package ru.kuznetcov.oleg;

public class Subtask {
	private int id;
	private int mainTaskId;
	private String description;
	private int currentResult;
	private int finishResult;
	private String name;

	public Subtask(int id, int mainTaskId, String name, String description, 
		int currentResult, int finishResult) {

		this.id = id;
		this.mainTaskId = mainTaskId;
		this.name = name;
		this.description = description;
		this.currentResult = currentResult;
		this.finishResult = finishResult;
	}

	public int getId() {
		return id;
	}

	public int getMainTaskId() {
		return mainTaskId;
	}

	public String getDescription() {
		return description;
	}

	public int getCurrentResult() {
		return currentResult;
	}

	public int getFinishResult() {
		return finishResult;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "id = " + id + ", mainTaskId = " + mainTaskId +
			", description = " + description + ", currentResult = " +
			currentResult + ", finishResult = " + finishResult;
	}
}