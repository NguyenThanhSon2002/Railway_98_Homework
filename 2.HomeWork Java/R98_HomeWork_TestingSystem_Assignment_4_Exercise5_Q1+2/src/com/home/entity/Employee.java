package com.home.entity;

public class Employee extends Staff {
	private String task;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, Gender gender, String address) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Employee: " + super.toString() + "[task=" + task + "]";
	}

}
