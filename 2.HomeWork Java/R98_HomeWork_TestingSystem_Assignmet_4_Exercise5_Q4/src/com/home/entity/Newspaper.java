package com.home.entity;

public class Newspaper extends Document {
	private int createDay;

	public Newspaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Newspaper(int docID, String creator, int releaseNumber) {
		super(docID, creator, releaseNumber);
		// TODO Auto-generated constructor stub
	}

	public int getCreateDay() {
		return createDay;
	}

	public void setCreateDay(int createDay) {
		this.createDay = createDay;
	}

	@Override
	public String toString() {
		return "Newspaper: " + super.toString() + "[createDay=" + createDay + "]";
	}

}
