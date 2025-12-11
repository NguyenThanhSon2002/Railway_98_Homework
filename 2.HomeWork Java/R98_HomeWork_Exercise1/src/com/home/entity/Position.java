package com.home.entity;

public class Position {

	public int PositionID;

	public Position_Name PositionName;

	// Có 2 cách khai báo enum, một là khai báo trực tiếp trên class, hai là tạo ra
	// một class mới để khai báo
	/*
	 * public enum Postion_Name { Dev, Test, Scrum_Master, PM }
	 */
	@Override
	public String toString() {
		return "Position [PositionID = " + PositionID + ", PositionName = " + PositionName + "]";
	}

}
