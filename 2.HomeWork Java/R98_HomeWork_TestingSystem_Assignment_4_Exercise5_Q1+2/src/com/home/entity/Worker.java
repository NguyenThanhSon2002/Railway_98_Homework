package com.home.entity;

public class Worker extends Staff {
	private int rank;

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(String name, int age, Gender gender, String address) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Worker: " + super.toString() + "[rank=" + rank + "]";
	}

}
