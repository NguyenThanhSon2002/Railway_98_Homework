package com.home.entity;

public class Position {

	public int positionID;

	public Position_Name positionName;

	// Có 2 cách khai báo enum, một là khai báo trực tiếp trên class, hai là tạo ra
	// một class mới để khai báo
	/*
	 * public enum Postion_Name { Dev, Test, Scrum_Master, PM }
	 */
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Position [PositionID = " + positionID + ", PositionName = " + positionName + "]";
	}

}
