package ru.kuznetcov.oleg;

public class Test {
	private String str;
	private int id;

	public Test(String str, int id) {
		this.str = str;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id = " + id + ", str = " + str + ".";
	}
}