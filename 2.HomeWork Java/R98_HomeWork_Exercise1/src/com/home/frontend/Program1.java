package com.home.frontend;

import java.time.LocalDate;

import com.home.entity.Account;
import com.home.entity.Department;
import com.home.entity.Group;
import com.home.entity.Position;

public class Program1 {
	public static void main(String[] args) {

		// Phòng ban 1
		Department department1 = new Department();
		department1.DepartmentID = 1;
		department1.DepartmentNameString = "Phòng giám đốc";

		// Phòng ban 2
		Department department2 = new Department();
		department2.DepartmentID = 2;
		department2.DepartmentNameString = "Phòng phó giám đốc";

		// Phòng ban 3
		Department department3 = new Department();
		department3.DepartmentID = 2;
		department3.DepartmentNameString = "Phòng Sale";

		System.out.println(
				"Thông tin phòng có ID " + department1.DepartmentID + ": " + department1.DepartmentNameString + "\n");
		System.out.println(
				"Thông tin phòng có ID " + department2.DepartmentID + ": " + department2.DepartmentNameString + "\n");
		System.out.println(
				"Thông tin phòng có ID " + department3.DepartmentID + ": " + department3.DepartmentNameString + "\n");

		// Vị trí số 1
		Position position1 = new Position();
		position1.PositionID = 1;
		position1.PostionName = "Dev";

		// Vị trí số 2
		Position position2 = new Position();
		position2.PositionID = 2;
		position2.PostionName = "Test";

		// Vị trí số 3
		Position position3 = new Position();
		position3.PositionID = 3;
		position3.PostionName = "ScrumMaster";

		// Vị trí số 4
		Position position4 = new Position();
		position4.PositionID = 4;
		position4.PostionName = "PM";

		System.out.println("Thông tin vị trí có ID " + position1.PositionID + ": " + position1.PostionName + "\n");
		System.out.println("Thông tin vị trí có ID " + position2.PositionID + ": " + position2.PostionName + "\n");
		System.out.println("Thông tin vị trí có ID " + position3.PositionID + ": " + position3.PostionName + "\n");
		System.out.println("Thông tin vị trí có ID " + position4.PositionID + ": " + position4.PostionName + "\n");

		// Thành viên số 1
		Account account1 = new Account();
		account1.AccoutID = 1;
		account1.Email = "nguyenvana@gmail.com";
		account1.UserName = "NguyenVanA01";
		account1.FullName = "Nguyễn Văn A";
		account1.DepartmentID = department1.DepartmentID;
		account1.PositionID = position1.PositionID;
		account1.createDate = LocalDate.now();

		// Thành viên số 2
		Account account2 = new Account();
		account2.AccoutID = 2;
		account2.Email = "trananh@gmail.com";
		account2.UserName = "TranAnh02";
		account2.FullName = "Trần Anh";
		account2.DepartmentID = department2.DepartmentID;
		account2.PositionID = position2.PositionID;
		account2.createDate = LocalDate.now();

		// Thành viên số 3
		Account account3 = new Account();
		account3.AccoutID = 3;
		account3.Email = "leminh@gmail.com";
		account3.UserName = "LeMinh03";
		account3.FullName = "Lê Minh";
		account3.DepartmentID = department3.DepartmentID;
		account3.PositionID = position1.PositionID;
		account3.createDate = LocalDate.now();

		// Thành viên số 4
		Account account4 = new Account();
		account4.AccoutID = 4;
		account4.Email = "phuongnt@gmail.com";
		account4.UserName = "PhuongNT04";
		account4.FullName = "Nguyễn Thị Phương";
		account4.DepartmentID = department1.DepartmentID;
		account4.PositionID = position4.PositionID;
		account4.createDate = LocalDate.now();

		System.out.println("Thông tin thành viên có ID " + account1.AccoutID + ":\n" + "Email: " + account1.Email
				+ "\nUserName: " + account1.UserName + "\nFullName: " + account1.FullName + "\nPhòng ban: "
				+ account1.DepartmentID + "\nVị trí: " + account1.PositionID + "\nNgày tạo Account: "
				+ account1.createDate + "\n");
		System.out.println("Thông tin thành viên có ID " + account2.AccoutID + ":\n" + "Email: " + account2.Email
				+ "\nUserName: " + account2.UserName + "\nFullName: " + account2.FullName + "\nPhòng ban: "
				+ account2.DepartmentID + "\nVị trí: " + account2.PositionID + "\nNgày tạo Account: "
				+ account2.createDate + "\n");
		System.out.println("Thông tin thành viên có ID " + account3.AccoutID + ":\n" + "Email: " + account3.Email
				+ "\nUserName: " + account3.UserName + "\nFullName: " + account3.FullName + "\nPhòng ban: "
				+ account3.DepartmentID + "\nVị trí: " + account3.PositionID + "\nNgày tạo Account: "
				+ account3.createDate + "\n");
		System.out.println("Thông tin thành viên có ID " + account4.AccoutID + ":\n" + "Email: " + account4.Email
				+ "\nUserName: " + account4.UserName + "\nFullName: " + account4.FullName + "\nPhòng ban: "
				+ account4.DepartmentID + "\nVị trí: " + account4.PositionID + "\nNgày tạo Account: "
				+ account4.createDate + "\n");

		// Nhóm số 1
		Group group1 = new Group();
		group1.GroupID = 1;
		group1.GroupName = "Nhóm công ty";
		group1.CreatorID = account1.AccoutID;
		group1.CreateDate = LocalDate.now();

		// Nhóm số 2
		Group group2 = new Group();
		group2.GroupID = 2;
		group2.GroupName = "Nhóm Sale";
		group2.CreatorID = account2.AccoutID;
		group2.CreateDate = LocalDate.now();

		// Nhóm số 3
		Group group3 = new Group();
		group3.GroupID = 3;
		group3.GroupName = "Nhóm Kỹ thuật";
		group3.CreatorID = account3.AccoutID;
		group3.CreateDate = LocalDate.now();

		// Nhóm số 4
		Group group4 = new Group();
		group4.GroupID = 4;
		group4.GroupName = "Nhóm Quản lý dự án";
		group4.CreatorID = account4.AccoutID;
		group4.CreateDate = LocalDate.now();

		System.out.println("Thông tin: " + group1.GroupName + "\nID nhóm: " + group1.GroupID + "\nNgười tạo nhóm: "
				+ group1.CreatorID + "\nNgày tạo nhóm: " + group1.CreateDate);
		System.out.println("Thông tin: " + group2.GroupName + "\nID nhóm: " + group2.GroupID + "\nNgười tạo nhóm: "
				+ group2.CreatorID + "\nNgày tạo nhóm: " + group2.CreateDate + "\n");
		System.out.println("Thông tin: " + group3.GroupName + "\nID nhóm: " + group3.GroupID + "\nNgười tạo nhóm: "
				+ group3.CreatorID + "\nNgày tạo nhóm: " + group3.CreateDate + "\n");
		System.out.println("Thông tin: " + group4.GroupName + "\nID nhóm: " + group4.GroupID + "\nNgười tạo nhóm: "
				+ group4.CreatorID + "\nNgày tạo nhóm: " + group4.CreateDate + "\n");

	}
}
