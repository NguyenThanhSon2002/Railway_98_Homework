package com.home.frontend;

import com.home.entity.Department;

public class Program1 {
	public static void main(String[] args) {
		Department department1 = new Department();
		department1.DepartmentID = 1;
		department1.DepartmentNameString = "Phòng giám đốc";
		System.out
				.println("Thông tin phòng có ID " + department1.DepartmentID + ": " + department1.DepartmentNameString);
	}
}
