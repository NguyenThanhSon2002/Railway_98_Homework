package com.home.entity;

public class Department {
	// ALt + shift + S để tạo toString nhanh
	public int departmentID;
	public String departmentName;

	// Question 1:
	// Tạo constructor cho department:
	// a) không có parameters
	// b) Có 1 parameter là nameDepartment và default id của
	// Department = 0
	// Khởi tạo 1 Object với mỗi constructor ở trên

	public Department() {

	}

	public Department(String nameDepartment) {
		this.departmentID = 1;
		this.departmentName = nameDepartment;
	}

	public void showDepInfo() {
		System.out.println("Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]");
	}

}
