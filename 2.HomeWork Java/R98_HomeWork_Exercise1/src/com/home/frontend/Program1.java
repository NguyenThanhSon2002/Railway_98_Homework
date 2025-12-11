package com.home.frontend;

import java.time.LocalDate;

import com.home.entity.Account;
import com.home.entity.Department;
import com.home.entity.Group;
import com.home.entity.Position;
import com.home.entity.Position_Name;

public class Program1 {
	public static void main(String[] args) {

		// Tạo ra các phòng ban
		// Phòng ban 1
		Department department1 = new Department();
		department1.DepartmentID = 1;
		department1.DepartmentName = "Phòng giám đốc";

		// Phòng ban 2
		Department department2 = new Department();
		department2.DepartmentID = 2;
		department2.DepartmentName = "Phòng phó giám đốc";

		// Phòng ban 3
		Department department3 = new Department();
		department3.DepartmentID = 2;
		department3.DepartmentName = "Phòng Sale";

		System.out.println("toString(): " + department1.toString());
		System.out.println("toString(): " + department2.toString());
		System.out.println("toString(): " + department3.toString());
		System.out.println("--------------------");

		// Tạo ra các vị trí
		// Vị trí số 1
		Position position1 = new Position();
		position1.PositionID = 1;
		position1.PositionName = Position_Name.Dev;

		// Vị trí số 2
		Position position2 = new Position();
		position2.PositionID = 2;
		position2.PositionName = Position_Name.Test;

		// Vị trí số 3
		Position position3 = new Position();
		position3.PositionID = 3;
		position3.PositionName = Position_Name.Scrum_Master;

		// Vị trí số 4
		Position position4 = new Position();
		position4.PositionID = 4;
		position4.PositionName = Position_Name.PM;

		System.out.println("toString(): " + position1.toString());
		System.out.println("toString(): " + position2.toString());
		System.out.println("toString(): " + position3.toString());
		System.out.println("toString(): " + position4.toString());
		System.out.println("--------------------");

		// Tạo ra các account
		// Thành viên số 1
		Account account1 = new Account();
		account1.AccoutID = 1;
		account1.Email = "nguyenvana@gmail.com";
		account1.UserName = "NguyenVanA01";
		account1.FullName = "Nguyễn Văn A";
		account1.Department = department1;
		account1.Position = position1;
		// account1.createDate = LocalDate.of(2020, 9, 23); - đưa dữ liệu ngày vào
		account1.createDate = LocalDate.now();

		// Thành viên số 2
		Account account2 = new Account();
		account2.AccoutID = 2;
		account2.Email = "trananh@gmail.com";
		account2.UserName = "TranAnh02";
		account2.FullName = "Trần Anh";
		account2.Department = department2;
		account2.Position = position2;
		account2.createDate = LocalDate.now();

		// Thành viên số 3
		Account account3 = new Account();
		account3.AccoutID = 3;
		account3.Email = "leminh@gmail.com";
		account3.UserName = "LeMinh03";
		account3.FullName = "Lê Minh";
		account3.Department = department3;
		account3.Position = position1;
		account3.createDate = LocalDate.now();

		// Thành viên số 4
		Account account4 = new Account();
		account4.AccoutID = 4;
		account4.Email = "phuongnt@gmail.com";
		account4.UserName = "PhuongNT04";
		account4.FullName = "Nguyễn Thị Phương";
		account4.Department = department1;
		account4.Position = position4;
		account4.createDate = LocalDate.now();

		System.out.println("toString(): " + account1.toString());
		System.out.println("--------------------");
		System.out.println("toString(): " + account2.toString());
		System.out.println("--------------------");
		System.out.println("toString(): " + account3.toString());
		System.out.println("--------------------");
		System.out.println("toString(): " + account4.toString());
		System.out.println("--------------------");

		// Tạo ra các nhóm
		// Nhóm số 1
		Group group1 = new Group();
		group1.GroupID = 1;
		group1.GroupName = "Nhóm công ty";
		group1.CreatorID = account1;
		group1.CreateDate = LocalDate.now();

		// Nhóm số 2
		Group group2 = new Group();
		group2.GroupID = 2;
		group2.GroupName = "Nhóm Sale";
		group2.CreatorID = account2;
		group2.CreateDate = LocalDate.now();

		// Nhóm số 3
		Group group3 = new Group();
		group3.GroupID = 3;
		group3.GroupName = "Nhóm Kỹ thuật";
		group3.CreatorID = account3;
		group3.CreateDate = LocalDate.now();

		// Nhóm số 4
		Group group4 = new Group();
		group4.GroupID = 4;
		group4.GroupName = "Nhóm Quản lý dự án";
		group4.CreatorID = account4;
		group4.CreateDate = LocalDate.now();

		// khai báo group mà account tham gia
		Group[] groups_Account1 = { group1, group2 };
		account1.groups = groups_Account1;

		Group[] groups_Account2 = { group2, group3 };
		account2.groups = groups_Account2;

		Group[] groups_Account3 = { group3, group4 };
		account3.groups = groups_Account3;

		Group[] groups_Account4 = { group1, group2, group4 };
		account4.groups = groups_Account4;

		System.out.println("toString(): " + group1.toString());
		System.out.println("--------------------");
		System.out.println("toString(): " + group2.toString());
		System.out.println("--------------------");
		System.out.println("toString(): " + group3.toString());
		System.out.println("--------------------");
		System.out.println("toString(): " + group4.toString());
		System.out.println("--------------------");

	}
}
