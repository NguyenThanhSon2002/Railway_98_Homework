package com.home.entity;

public class Department {
	// ALt + shift + S để tạo toString nhanh
	public int DepartmentID;
	public String DepartmentName;

	@Override
	public String toString() {
		return "Department [DepartmentID = " + DepartmentID + ", DepartmentName = " + DepartmentName + "]";
	}
}
