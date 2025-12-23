package com.home.frontend;

import java.time.LocalDate;

import com.home.entity.Account;
import com.home.entity.CategoryQuestion;
import com.home.entity.Department;
import com.home.entity.Group;
import com.home.entity.Position;
import com.home.entity.Position_Name;
import com.home.entity.TypeQuestion;
import com.home.entity.TypeQuestion_Name;

public class Exercise2 {
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

		// Phòng ban 4
		Department department4 = new Department();
		department4.DepartmentID = 4;
		department4.DepartmentName = "Phòng IT";

		// Phòng ban 5
		Department department5 = new Department();
		department5.DepartmentID = 5;
		department5.DepartmentName = "Phòng kế toán";

		/*
		 * System.out.println("toString(): " + department1.toString());
		 * System.out.println("toString(): " + department2.toString());
		 * System.out.println("toString(): " + department3.toString());
		 * System.out.println("toString(): " + department4.toString());
		 * System.out.println("toString(): " + department5.toString());
		 * System.out.println("--------------------");
		 */

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

		/*
		 * System.out.println("toString(): " + position1.toString());
		 * System.out.println("toString(): " + position2.toString());
		 * System.out.println("toString(): " + position3.toString());
		 * System.out.println("toString(): " + position4.toString());
		 * System.out.println("--------------------");
		 */

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
		account4.Department = department4;
		account4.Position = position4;
		account4.createDate = LocalDate.now();

		// Thành viên số 5
		Account account5 = new Account();
		account5.AccoutID = 5;
		account5.Email = "nguyenvanc@gmail.com";
		account5.UserName = "NguyenVanC05";
		account5.FullName = "Nguyễn Văn C";
		account5.Department = department5;
		account5.Position = position3;
		account5.createDate = LocalDate.now();

		/*
		 * System.out.println("toString(): " + account1.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + account2.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + account3.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + account4.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + account5.toString());
		 * System.out.println("--------------------");
		 */

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

		// Nhóm số 5
		Group group5 = new Group();
		group5.GroupID = 5;
		group5.GroupName = "Nhóm chăm sóc khách hàng";
		group5.CreatorID = account4;
		group5.CreateDate = LocalDate.now();

		// khai báo group mà account tham gia
		Group[] groups_Account1 = { group1, group2 };
		account1.groups = groups_Account1;

		// Group[] groups_Account2 = null;
		Group[] groups_Account2 = { group2, group3, group1 };
		account2.groups = groups_Account2;

		Group[] groups_Account3 = { group3, group4 };
		account3.groups = groups_Account3;

		Group[] groups_Account4 = { group4, group5 };
		account4.groups = groups_Account4;

		/*
		 * System.out.println("toString(): " + group1.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + group2.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + group3.toString());
		 * System.out.println("--------------------"); System.out.println("toString(): "
		 * + group4.toString()); System.out.println("--------------------");
		 * System.out.println("toString(): " + group5.toString());
		 * System.out.println("--------------------");
		 */

		// Kiểu câu hỏi số 1
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeID = 1;
		typeQuestion1.typeName = TypeQuestion_Name.Essay;

		// Kiểu câu hỏi số 2
		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeID = 2;
		typeQuestion2.typeName = TypeQuestion_Name.MultipleChoice;

		/*
		 * System.out.println("toString: " + typeQuestion1.toString());
		 * System.out.println("toString: " + typeQuestion2.toString());
		 * System.out.println("--------------------");
		 */

		// Câu hỏi 1
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryID = 1;
		categoryQuestion1.categoryNameString = "Câu hỏi về Java";

		// Câu hỏi 2
		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryID = 2;
		categoryQuestion2.categoryNameString = "Câu hỏi về NET";

		// Câu hỏi 3
		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryID = 3;
		categoryQuestion3.categoryNameString = "Câu hỏi về SQL";

		// Câu hỏi 4
		CategoryQuestion categoryQuestion4 = new CategoryQuestion();
		categoryQuestion4.categoryID = 4;
		categoryQuestion4.categoryNameString = "Câu hỏi về Postman";

		// Câu hỏi 5
		CategoryQuestion categoryQuestion5 = new CategoryQuestion();
		categoryQuestion5.categoryID = 5;
		categoryQuestion5.categoryNameString = "Câu hỏi về Ruby";
		// Exercise 2 (Optional): System out printf
		// Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in
		// ra số nguyên đó

		/*
		 * int a = 5; System.out.printf("Answer1: %d\n", a);
		 */

		// Question 2:
		// Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
		// ra số nguyên đó thành định dạng như sau: 100,000,000

		/*
		 * int b = 100000000; System.out.printf("%,d\n", b);
		 */

		// Question 3:
		// Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
		// thực đó chỉ bao gồm 4 số đằng sau

		/*
		 * float c = 5.567098f; System.out.printf("%.4f\n", c);
		 */

		// Question 4:
		// Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
		// dạng như sau:
		// Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
		// Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.

		/*
		 * String name = "Nguyễn Văn A";
		 * System.out.printf("Tên tôi là %s và tôi đang độc thân\n", name);
		 */

		// Question 5:
		// Lấy thời gian bây giờ và in ra theo định dạng sau:
		// 24/04/2020 11h:16p:20s

		/*
		 * LocalDateTime now = LocalDateTime.now();
		 * 
		 * DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
		 * 
		 * System.out.println(now.format(formatter));
		 */

		// Question 6:
		// In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
		// table (giống trong Database)

		Account[] account_array = { account1, account2, account3, account4, account5 };

		System.out.println("AccountID     Email                       Name");
		for (Account account_1 : account_array) {
			System.out
					.println(account_1.AccoutID + "             " + account_1.Email + "        " + account_1.FullName);
		}
		System.out.println("--------------------");

	}
}
