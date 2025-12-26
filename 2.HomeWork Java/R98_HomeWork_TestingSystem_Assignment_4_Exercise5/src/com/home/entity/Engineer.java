package com.home.entity;

public class Engineer extends Staff {
	private String specialized;

	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Engineer(String name, int age, Gender gender, String address) {
		super(name, age, gender, address); // khai báo các phần tử cha vào phần tử con
		// TODO Auto-generated constructor stub
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}

	@Override
	public String toString() {

		return "Engineer: " + super.toString() + ", specialized=" + specialized;
	}

}
